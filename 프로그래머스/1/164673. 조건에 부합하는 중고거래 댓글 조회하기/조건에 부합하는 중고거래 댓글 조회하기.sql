# -- 코드를 입력하세요
# SELECT A.TITLE
#      , B.BOARD_ID
#      , B.REPLY_ID
#      , B.WRITER_ID
#      , B.CONTENTS
#      , DATE_FORMAT(B.CREATED_DATE, '%Y-%m-%d') AS CREATED_DATE
#   FROM USED_GOODS_BOARD A 
#   JOIN USED_GOODS_REPLY B
#     ON A.BOARD_ID = B.BOARD_ID
#  WHERE DATE_FORMAT(B.CREATED_DATE, '%Y-%m-%d') LIKE '%2022-10%'
#  ORDER BY B.CREATED_DATE, A.CREATED_DATE ASC;

SELECT B.TITLE,B.BOARD_ID,R.REPLY_ID,R.WRITER_ID,R.CONTENTS,DATE_FORMAT(R.CREATED_DATE,'%Y-%m-%d') AS CREATED_DATE
FROM USED_GOODS_BOARD AS B
JOIN USED_GOODS_REPLY AS R 
ON R.BOARD_ID = B.BOARD_ID
WHERE DATE_FORMAT(B.CREATED_DATE,'%Y-%m') = '2022-10'
ORDER BY R.CREATED_DATE,B.TITLE;