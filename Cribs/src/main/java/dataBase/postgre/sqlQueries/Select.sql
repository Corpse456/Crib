SELECT title, rate_im 
FROM games 
WHERE rate_users > 8 
	AND rate_im > 8 
	AND rel_date 
	AND lower(genre) like '%приключ' 
	AND rel_date > '2015-01-01' 
ORDER BY rate_im, rate_users DESC