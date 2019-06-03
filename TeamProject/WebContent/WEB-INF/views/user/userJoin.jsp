<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%@ include file="/WEB-INF/views/common/header.jsp"%>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/user/userJoin.css" />
<!-- 회원가입 view단 -->
<article>
	<div id="joinMain">
	<span id="title">회원 가입</span>

		<form action="<%=request.getContextPath()%>/views/user/userEnrollEnd" method="post" onsubmit="return validate();">
			<table id='join'>
				<colgroup>
					<col style="width: 30%" />
					<col style="width: 50%" />
					<col />
				</colgroup>
				<tbody>
					<tr>
						<th style="width:15px;">아이디</th>
						<td><input maxlength="15" minlength="4" type="text" name="userId"
							id="userId"  placeholder="영소/대문자+숫자, 4~15자리 " required="required">
						<button type='button' onclick="checkId();" id='check'>ID중복검사</button></td>
					</tr>
					<tr>
						<th>비밀번호</th>
						<td><input maxlength="15" minlength="4" type="password"
							name="userPwd" id="userPwd" placeholder="특수문자 포함 4~15자리" required="required" ></td>
					</tr>
					<tr>
						<th>비밀번호 확인</th>
						<td><input maxlength="15" minlength="4" type="password"
							name="re_userPwd" id="re_userPwd"  placeholder="비밀번호 재입력" required="required" ></td>
					</tr>
					<tr>
						<th>이름</th>
						<td><input minlength='2' type="text" name="userName" id="userName" ></td>
					</tr>
					<tr>
						<th>성별</th>
						<td>
						<input type="radio" name="gender" class="gender" value="F" /><label for="gender">여성</label>&nbsp;&nbsp;
						<input type="radio" name="gender" class="gender" value="M" /><label for="gender">남성</label>
						</td>
					</tr>
					<tr>
					<th>주민등록번호</th>
					<td>
					<input type="text" class="ssn" name="ssn_1" id="ssn_1" maxlength='6'/>&nbsp;ㅡ&nbsp;
					<input type="password" class="ssn" name="ssn_2" id="ssn_2" maxlength='7' />
					</td>
					</tr>
					<tr>
						<th>이메일</th>
						<td><input type="email" name="email" id="mail" class='userInfo' required="required"></td>
					</tr>
					<tr>
						<th>주소</th>
						<td><input type="text" name="addr1" id="address1" class="addr" required>
							<button type="button" onclick='searchAddr();' >주소검색</button> <br>
		
							<input type="text" name="addr2" id="address2" class="addr" required></td>
					</tr>
					<tr>
						<th>연락처</th>
						<td><select  id="tel1" class='userInfo' name='phone_1' required>
								<option value="010">010</option>
								<option value="011">011</option>
								<option value="070">070</option>
						</select> - 
						<input type="text" id="tel2" name='phone_2' maxlength="4" class="tel" required>- 
							<input type="text" id="tel3" name='phone_3' maxlength="4" class='tel' required></td>
					</tr>
					<tr>
						<th>관심사</th>
						<td>
						<div id="interest_List1">
						<!-- 1차 분류 -->
						<select  name="interest1" class="selectBox" >
						  <option selected disabled>관심사</option>
						  <option value="A">패션의류/잡화</option>
						  <option value="B">뷰티</option>
						  <option value="C">출산/유아동</option>
						  <option value="D">식품</option>
						  <option value="E">주방용품</option>
						  <option value="F">생활용품</option>
						  <option value="G">홈인테리어</option>
						  <option value="H">가전디지털</option>
						  <option value="I">스포츠/레저</option>
						  <option value="J">자동차용품</option>
						  <option value="K">도서/음반/DVD</option>
						  <option value="L">완구/취미</option>
						  <option value="M">문구/오피스</option>
						  <option value="N">반려동물용품</option>
						  <option value="O">헬스/건강식품</option>
						</select>
						<select  name="interest2" class="selectBox" >
						  <option selected disabled>관심사</option>
						  <option value="A">패션의류/잡화</option>
						  <option value="B">뷰티</option>
						  <option value="C">출산/유아동</option>
						  <option value="D">식품</option>
						  <option value="E">주방용품</option>
						  <option value="F">생활용품</option>
						  <option value="G">홈인테리어</option>
						  <option value="H">가전디지털</option>
						  <option value="I">스포츠/레저</option>
						  <option value="J">자동차용품</option>
						  <option value="K">도서/음반/DVD</option>
						  <option value="L">완구/취미</option>
						  <option value="M">문구/오피스</option>
						  <option value="N">반려동물용품</option>
						  <option value="O">헬스/건강식품</option>
						</select>
						<select name="interest3" class="selectBox" >
						  <option selected disabled>관심사</option>
						  <option value="A">패션의류/잡화</option>
						  <option value="B">뷰티</option>
						  <option value="C">출산/유아동</option>
						  <option value="D">식품</option>
						  <option value="E">주방용품</option>
						  <option value="F">생활용품</option>
						  <option value="G">홈인테리어</option>
						  <option value="H">가전디지털</option>
						  <option value="I">스포츠/레저</option>
						  <option value="J">자동차용품</option>
						  <option value="K">도서/음반/DVD</option>
						  <option value="L">완구/취미</option>
						  <option value="M">문구/오피스</option>
						  <option value="N">반려동물용품</option>
						  <option value="O">헬스/건강식품</option>
						</select>
							
						</div>
						<div id="interest_List2">
						
						</div>
						</td>
					</tr>
					<tr>
					<th></th>
					<td colspan="2">
					<button type="submit" id='submitBtn' class="btn btn-outline-secondary">회원가입</button>
					<!-- <button type="submit" id='submitBtn' onclick="return validate();">회원가입</button> --></td>
					</tr>
					
					
				</tbody>
			</table>

		</form>



	</div>










</article>

<script>

//주소찾기
function searchAddr(){
  new daum.Postcode({
  oncomplete: function(data) {
      // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분입니다.
      // 예제를 참고하여 다양한 활용법을 확인해 보세요.
      console.log('주소 : '+data.address);
      
      var address1=data.address;
      var jibun=data.jibunAddress;
      $('#address1').val(address1);
      //지번주소 표기는 폐기처리.$('#address2').val('(지번주소)'+jibun+' ');
 

  }
}).open();
}



//validate 에서 호출할 함수(리턴값 확인용)
function regTest(reg,info,msg){
	console.log($('#'+info).val());
  if(reg.test($('#'+info).val())){
      return true;
  }else{
      alert(msg);
      return false;
  }
}



//form 확인 및 submit버튼 활성화
function validate(){
  var result=true;
  
  var reg=/^[\S\w\d]{4,15}$/;
  bool=regTest(reg,'userPwd','비밀번호를 다시 입력해주세요.');
  console.log('비밀번호 체크 :'+bool);
  if(!bool){
      result=false;
  }else{
	  reg=/^[\d]{6}$/;
	  bool=regTest(reg,'ssn_1','주민등록번호는 숫자만 입력가능합니다.');
	  console.log('주민1 : '+bool);
	  if(!bool){
		  result=false;
	  }else{
		  reg=/^[0-9]{7}$/;
		  bool=regTest(reg,'ssn_2','주민등록번호는 숫자만 입력가능합니다.');
		  console.log('주민2 : '+bool);
		  if(!bool){
		  result=false;
		  }else{
		      reg=/^[\d]{4}$/;
		      bool=regTest(reg,'tel2','전화번호는 숫자만 입력가능합니다. 다시 입력해주세요.');
		      if(!bool){
		      result=false;
		      }else{
		          bool=regTest(reg,'tel3','전화번호는 숫자만 입력가능합니다. 다시 입력해주세요.');
		          if(!bool){
		              result=false;
		          }
	  			}
  			}
      	}
  	}
  var pwdIn=$('#userPwd').val();
  var pwdCheck=$('#re_userPwd').val();
  if(pwdIn!==pwdCheck){
	  alert('입력하신 비밀번호와 비밀번호 확인 부분이 동일하지 않습니다. 다시 입력해주세요');
	  result=false;
  }
  return result;
}

//form제출



//아이디검사-아이디 중복 여부와 유효성 검사
function checkId(){
  var reg=/^[a-zA-Z0-9\S]{4,15}$/g;
  var str=$('#userId').val();
  //c=> 화살표함수, finc(function dssds)==> each문을 돌리는것과 동일하다. c라는 것은 파라미터(function(c))와 같고 인자 하나를 꺼내서 그의 id값을 검사 후 true이면 
  //영어와 숫자로 이루어진 4~15자리 
  var bool=regTest(reg,'userId','아이디가 부적절합니다.4자 이상 입력해주세요');
  if(bool==true){
      //한글이 들어갔는지 체크
      reg=/[\w]/;
      var cnt=0;
      //cnt변수로 확인. 글자길이와 한글을 걸러낸 문자열의 길이가 다르면 false리턴
      for(var i=0;i<str.length;i++){
                  if(reg.test(str[i])){
                  ++cnt;  
              }
          } 
      var leng=str.length;
      if(leng===cnt){
          bool=true;
      }else {
          bool=false;
          alert('아이디에 한글이 포함될 수 없습니다.');
      }
      
      
      if(bool==true){
              if(bool){
              alert('사용가능한 아이디입니다.');
              $('#check').prop('disabled',true);
              return true;
          }else{
              alert('이미 존재하거나 사용할 수 없는 아이디입니다.');
              return false;
          }
      } 
  }
}

</script>


<%@ include file="/WEB-INF/views/common/footer.jsp"%>