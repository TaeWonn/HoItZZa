package point.model.vo;

public class Point {
	// 현재 포인트 관련 테이블
	// 이용자의 포인트는 현재 User객체의 포인트를 바꿔주는 방식으로 
	// DB에 트리거를 통해 자동으로 변경되도록 한다.
//	create table  user_point  (
//		 user_id varchar2(15) not null,
//		 point number default 0 not null,
//	     constraint pk_point_user_id primary key(user_id)
//	);
	
//	--포인트 충전내역 테이블
//	create table  point_charge  (
//		 charge_no number not null,
//		 charge_writer varchar2(15) not null,
//		 charge_money number not null,
//		 charge_date date default sysdate not null,
//	     constraint pk_charge_no primary key(charge_no),
//	     constraint fk_charge_writer foreign key(charge_writer) references user_point(user_id)
//	);
	
	// 거래내역 테이블이 바람직하다.
//	--포인트 소모내역 테이블
//	create table  point_use  (
//		 use_no number not null,
//		 use_id varchar2(15) not null,
//		 use_money 	number not null,
//		 use_date date default sysdate not null,
//	     constraint pk_use_no primary key(use_no),
//	     constraint fk_use_id foreign key(use_id) references user_point(user_id)
//	);
}
