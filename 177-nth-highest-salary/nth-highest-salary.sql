CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  SET N = N - 1;

  RETURN (
      WITH cte AS (
          SELECT DISTINCT salary
          FROM Employee
          ORDER BY salary DESC
      )
      SELECT salary
      FROM cte
      LIMIT 1 OFFSET N
  );
END