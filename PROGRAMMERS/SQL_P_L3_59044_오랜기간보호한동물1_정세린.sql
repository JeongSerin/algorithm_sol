SELECT INS.NAME, INS.DATETIME
FROM ANIMAL_INS AS INS LEFT OUTER JOIN ANIMAL_OUTS AS OUTS
ON INS.ANIMAL_ID = OUTS.ANIMAL_ID
WHERE OUTS.ANIMAL_ID IS NULL
ORDER BY DATETIME
LIMIT 3;