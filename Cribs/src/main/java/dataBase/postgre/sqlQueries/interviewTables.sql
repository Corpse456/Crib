create table profile
(
    id            bigserial primary key,
    nickname      varchar,
    registered_at timestamp
);

create table post
(
    id            bigserial primary key,
    owner_id      bigint references profile (id),
    body          text,
    interested_at timestamp,
    likes_count   int
);

create table subscription_count
(
    profile_id      bigint references profile (id),
    followers_count int,
    following_count int
);

---------------------------------------------------------------------------------------------------
-- генерация пользователей
WITH RECURSIVE profile_generator(id, nickname, registered_at, cte_level) AS (SELECT 1,
                                                                                    'User ' || 1,
                                                                                    NOW() - (random() * INTERVAL '365 days'),
                                                                                    1
                                                                             UNION ALL
                                                                             SELECT p.id + 1,
                                                                                    'User ' || (p.id + 1),
                                                                                    NOW() - (random() * INTERVAL '365 days'),
                                                                                    cte_level + 1
                                                                             FROM profile_generator p
                                                                             WHERE cte_level < 100)
INSERT
INTO profile (id, nickname, registered_at)
SELECT id, nickname, registered_at
FROM profile_generator;

-- генерация постов
INSERT INTO post (owner_id, body, interested_at, likes_count)
SELECT profile.id,
       'Post ' || (random() * 1000)::int,
       NOW() - (random() * INTERVAL '30 days'),
       (random() * 100)::int
FROM profile
         CROSS JOIN (SELECT generate_series(1, 20) AS num_posts) AS post_counts
WHERE random() < 0.5;
-- вероятность создания поста для каждого пользователя


-- генерация подписчиков и подписок
INSERT INTO subscription_count (profile_id, followers_count, following_count)
SELECT id,
       (random() * 2000)::int,
       (random() * 2000)::int
FROM profile;
---------------------------------------------------------------------------------------------------

select *
from profile p
         join subscription_count sc on p.id = sc.profile_id
where sc.followers_count > 1000;

select pr.*, count(po.id)
from profile pr
         join post po on pr.id = po.owner_id
group by pr.id
having count(po.id) > 10;

create index on post (owner_id);
explain analyze
select *
from post
where likes_count > 25
  and owner_id = 10;

create index on post (owner_id, likes_count);
explain analyze
select *
from post
where owner_id = 10;
