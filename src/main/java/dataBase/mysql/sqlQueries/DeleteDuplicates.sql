create table TMP select ID from MDS_AMENITY_CHAR_FREE_TEXT_RESOLUTION group by FIRST_AMENITY_NAME, FIRST_CHARACTERISTIC_TEXT, SECOND_AMENITY_NAME, SECOND_CHARACTERISTIC_TEXT, CHECK_FREE_TEXT_SOL_ID, MASTER_AMENITY_ID having count(1) >= 1;
delete a from MDS_AMENITY_CHAR_FREE_TEXT_RESOLUTION a where a.ID not in ( select ID from TMP);
drop table TMP;

//another way
delete n1 FROM user_verification_file n1, user_verification_file n2 WHERE n1.verification_file > n2.verification_file AND n1.user_id = n2id;
