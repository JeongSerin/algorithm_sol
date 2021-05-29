SET @var := -1;

SELECT (@var := @var + 1) AS "HOUR",   (SELECT COUNT(*)
                                        FROM ANIMAL_OUTS
                                        WHERE HOUR(DATETIME) = @var) AS "COUNT"
FROM ANIMAL_OUTS
WHERE @var < 23