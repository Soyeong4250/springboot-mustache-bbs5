# 전체 리스트 조회문
select * from `likeliondb`.`nation_wide_hospitals` limit 100;

# 경기도 수원시에 있는 피부과를 조회하는 쿼리문
select hospital_name, full_address from `likeliondb`.`nation_wide_hospitals`
where full_address like '경기도 수원시%' and hospital_name like '%피부과%';

# 특정 주소와 업태구분명으로 조회하는 쿼리문
select business_type_name, hospital_name, full_address from `likeliondb`.`nation_wide_hospitals`
where business_type_name in ('보건소', '보건지소');