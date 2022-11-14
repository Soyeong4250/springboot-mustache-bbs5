# 전체 리스트 조회문
select * from `likeliondb`.`nation_wide_hospitals` limit 100;

# 경기도 수원시에 있는 피부과를 조회하는 쿼리문
select * from `likeliondb`.`nation_wide_hospitals`
where full_address like '경기도 수원시 %' and hospital_name like '%피부과%';