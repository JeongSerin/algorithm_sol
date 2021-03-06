SELECT INS.ANIMAL_ID, INS.ANIMAL_TYPE, INS.NAME
FROM ANIMAL_INS AS INS JOIN ANIMAL_OUTS AS OUTS
ON INS.ANIMAL_ID = OUTS.ANIMAL_ID

WHERE (OUTS.SEX_UPON_OUTCOME = "Spayed Female"
OR OUTS.SEX_UPON_OUTCOME = "Neutered Male")
AND INS.SEX_UPON_INTAKE != OUTS.SEX_UPON_OUTCOME