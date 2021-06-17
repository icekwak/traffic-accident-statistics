
/* 수도권 교통사고 비교 */
SELECT name, cityName, SUM(re_accident) AS sumAccident, SUM(re_death) AS sumDeath, SUM(re_injured1) AS sumInjured1, SUM(re_injured2) AS sumInjured2, SUM(re_injured3) AS sumInjured3
FROM rePackage INNER JOIN region ON rePackage.type = region.cityName
GROUP BY cityName
HAVING name = "수도권";

/* 수도권 지역 상세 */
SELECT name, cityName, regName, re_accident
FROM rePackage INNER JOIN region ON rePackage.type = region.cityName
WHERE name = "수도권"
ORDER BY re_accident DESC;



SELECT cityName, SUM(re_accident) AS sumAccident
FROM region
GROUP BY cityName
ORDER BY SUM(re_accident) DESC;

SELECT regName
FROM region
ORDER BY re_accident DESC;

SELECT name, SUM(re_accident) AS sumAccident, SUM(re_death) AS sumDeath, SUM(re_injured1) AS sumInjured1, SUM(re_injured2) AS sumInjured2, SUM(re_injured3) AS sumInjured3 FROM rePackage INNER JOIN region ON rePackage.type = region.cityName GROUP BY name