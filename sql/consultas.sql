-- i. Cantidad de empleados por segmento salarial

SELECT
  CASE
    WHEN SALARY < 3500 THEN 'Segmento A'
    WHEN SALARY >= 3500 AND SALARY < 8000 THEN 'Segmento B'
    ELSE 'Segmento C'
  END AS segmento_salarial,
  COUNT(*) AS cantidad_empleados
FROM employees
GROUP BY segmento_salarial;

-- ii. Cantidad de empleados por segmento salarial y departamento

SELECT
  d.DEPARTMENT_NAME,
  CASE
    WHEN e.SALARY < 3500 THEN 'Segmento A'
    WHEN e.SALARY >= 3500 AND e.SALARY < 8000 THEN 'Segmento B'
    ELSE 'Segmento C'
  END AS segmento_salarial,
  COUNT(*) AS cantidad_empleados
FROM employees e
JOIN departments d ON e.DEPARTMENT_ID = d.DEPARTMENT_ID
GROUP BY d.DEPARTMENT_NAME, segmento_salarial
ORDER BY d.DEPARTMENT_NAME, segmento_salarial;

-- iii. Información del empleado con mayor sueldo por cada departamento

SELECT
  e.EMPLOYEE_ID,
  e.FIRST_NAME,
  e.LAST_NAME,
  e.SALARY,
  d.DEPARTMENT_NAME
FROM employees e
JOIN departments d ON e.DEPARTMENT_ID = d.DEPARTMENT_ID
WHERE e.SALARY = (
  SELECT MAX(e2.SALARY)
  FROM employees e2
  WHERE e2.DEPARTMENT_ID = e.DEPARTMENT_ID
)
ORDER BY d.DEPARTMENT_NAME;

-- iv. Información de gerentes contratados hace más de 15 años
-- Observación:
-- Se consideró como "gerentes" a todos los empleados cuyo EMPLOYEE_ID
-- aparece como MANAGER_ID de otros empleados en la tabla employees.

SELECT
  e.EMPLOYEE_ID,
  e.FIRST_NAME,
  e.LAST_NAME,
  e.JOB_ID,
  e.SALARY,
  e.HIRE_DATE
FROM employees e
WHERE e.EMPLOYEE_ID IN (
    SELECT DISTINCT MANAGER_ID
    FROM employees
    WHERE MANAGER_ID IS NOT NULL
)
AND TIMESTAMPDIFF(YEAR, e.HIRE_DATE, CURDATE()) > 15
ORDER BY e.HIRE_DATE;

-- v. Salario promedio de los departamentos que tienen más de 10 empleados

SELECT
  d.DEPARTMENT_NAME,
  AVG(e.SALARY) AS salario_promedio,
  COUNT(e.EMPLOYEE_ID) AS cantidad_empleados
FROM employees e
JOIN departments d ON e.DEPARTMENT_ID = d.DEPARTMENT_ID
GROUP BY d.DEPARTMENT_NAME
HAVING COUNT(e.EMPLOYEE_ID) > 10
ORDER BY salario_promedio DESC;

-- vi. Información agrupada por país: empleados, salario y antigüedad
-- Observación:
-- Se consideró antigüedad como los años completos desde la fecha de contratación (HIRE_DATE) hasta la fecha actual (CURDATE()).
-- Se asumió que cada empleado pertenece a un país a través de la relación DEPARTMENTS → LOCATIONS → COUNTRIES.
SELECT
  c.COUNTRY_NAME,
  COUNT(e.EMPLOYEE_ID) AS cantidad_empleados,
  AVG(e.SALARY) AS salario_promedio,
  MAX(e.SALARY) AS salario_maximo,
  MIN(e.SALARY) AS salario_minimo,
  AVG(TIMESTAMPDIFF(YEAR, e.HIRE_DATE, CURDATE())) AS antiguedad_promedio
FROM employees e
JOIN departments d ON e.DEPARTMENT_ID = d.DEPARTMENT_ID
JOIN locations l ON d.LOCATION_ID = l.LOCATION_ID
JOIN countries c ON l.COUNTRY_ID = c.COUNTRY_ID
GROUP BY c.COUNTRY_NAME
ORDER BY cantidad_empleados DESC;
