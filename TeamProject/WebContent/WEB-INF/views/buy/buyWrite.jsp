<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="../common/error.jsp"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>


<link href="https://fonts.googleapis.com/css?family=Gothic+A1|Noto+Sans+KR&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/board/boardModified.css" />
 <link rel="stylesheet" href="<%=request.getContextPath()%>/css/header.css" />


<article id="article">

	<form action="<%=request.getContextPath()%>/board/boardWriteEnd"
	 method="post" enctype="multipart/form-data">
	 
	 <input type="hidden" name="boardCodeNo" />
	
		<h2 style="text-align: center">구매글 작성</h2>
		<br>
        <input type="text" class="alert alert-light" role="alert" name="boardTitle" id="boardTitle" placeholder="제목을 입력해주세요">
        <br>
        <input type="text" class="alert alert-light" role="alert" name="boardWriter" id="userId" value="<%=userLoggedIn.getUserId() %>" readonly> 


		<!-- 거래방식 -->
			<select class="custom-select" id="boardDeal" name="boardDeal">
                <option value="택배" selected>택배</option>
                <option value="직거래">직거래</option>
	        </select>
		
	    	<select class="custom-select" id="category1" name="category1" onchange="chageSelect()">
	                <option selected>카테고리 선택</option>
	                <option value="A">패션의류/잡화</option>
	                <option value="B">뷰티</option>
	                <option value="C">출산/유아농</option>
	                <option value="D">식품</option>
	                <option value="E">주방용품</option>
	                <option value="F">생활용품</option>
	                <option value="G">홈인테리어</option>
	                <option value="H">가전디지털</option>
	                <option value="I">스포츠/레저</option>
	                <option value="G">자동차용품</option>
	                <option value="K">도서/음반/DVD</option>
	                <option value="L">완구/취미</option>
	                <option value="M">문구/오피스</option>
	                <option value="N">반려동물용품</option>
	                <option value="O">헬스/건강식품</option>
	        </select>
	        <select class="custom-select" id="category2" name="category2" onchange="chageSelect2()">
	                <option value=""  selected>세부 카테고리</option></select>
        
              
        <br>
        <!-- <div id="img-viewer-container">
						<img id="img-viewer" width=350/>
					</div> -->
        <div contentEditable="true"  id="boardContent">
        
        <img id="img-viewer" style="display: block;"/>
        
        </div>
        
        <input type="hidden" name="boardContent">
        <br>
           <div class="filebox">
           			
					
	<input type="file" id="ex_img" onchange="loadImg(this);" name="upFile1">			 
    <label for="ex_img">이미지삽입</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <input multiple type="file" id="ex_filename" class="upload-hidden" name="upFile">
    
  <input class="upload-name" value="파일명" disabled="disabled">
  <label for="ex_filename">파일 업로드</label>
  <input type="file" id="ex_filename" class="upload-hidden" name="">
</div>
    
                <div id="buttons">
                  <button type="submit" class="btn btn-success" onclick="return validate();" value="버튼">등록</button>
                  <button type="button" class="btn btn-outline-danger" onclick="">취소</button>
                </div>
            </form>

</article>

<script>




function validate(){
	//제목
	var boardTitle = $("[name=boardTitle]").val();
	if(boardTitle.trim().length == 0){
		alert("제목을 입력하세요.");
		return false;
	}
	//내용
	var boardContent = $("#boardContent").text();
	if(boardContent.trim().length == 0){
		alert("내용을 입력하세요.");
		return false;
	}
	
	//카테고리
	var boardCodeNo = $("[name=boardCodeNo]").val();
	if(boardCodeNo.trim().length == 0){
		alert("카테고리를 선택하세요.");
		return false;
	}
	
	
	$("[name=boardContent]").val($("#boardContent").text());

	return true;
}


function loadImg(f){
	console.log(f.files);//FileList
	console.log(f.files[0]);//File 실제 업로드한 파일
	
	if(f.files && f.files[0]){
		var reader = new FileReader();
		//파일읽기메소드 호출. 읽기완료하면 onload에 등록된 함수를 호출
		reader.readAsDataURL(f.files[0]);
		
		reader.onload = function(){
			//result속성에는 파일컨텐츠 담겨있음.
			$("#img-viewer").attr("src", reader.result);
		}
	}
}




var fileTarget = $('.filebox .upload-hidden');

fileTarget.on('change', function(){ // 값이 변경되면
  if(window.FileReader){ // modern browser
    var filename = $(this)[0].files[0].name;
  }
  else { // old IE
    var filename = $(this).val().split('/').pop().split('\\').pop(); // 파일명만 추출
  }

  // 추출한 파일명 삽입
  $(this).siblings('.upload-name').val(filename);
});


function chageSelect(){
	
	
	var category1 = $("#category1").val();
			$.ajax({
				
				url: "<%=request.getContextPath()%>/buy/buycategory",
				data: "category1="+category1,//파라미터직렬화
				success: function(data){
					console.log(data);
					
					//넘어온 csv데이터가, 공백인경우
					if(data.trim().length == 0){
						console.log("공백넘어옴");
					}
					else{
						var nameArr = data.split(",");
						$("#category2").empty();
						$("#category2").append($("<option>"+"세부 카테고리"+"</option>"))
						for(var i=0; i<nameArr.length; i++){
							var option = $("<option>"+nameArr[i]+"</option>");
			                $("#category2").append(option);

						}	
						
					}
				}
			});//end of ajax
			$("[name=boardCodeNo]").val($("#category1").val());
}
			
			
			function chageSelect2(){
				var category2 = $("#category2 option:selected").text().toString();
						$.ajax({
							url: "<%=request.getContextPath()%>/buy/buycategory2",
							data: "category2="+category2,//파라미터직렬화
							success: function(data){
								console.log(data);
								
								//넘어온 csv데이터가, 공백인경우
								if(data.trim().length == 0){
									console.log("공백넘어옴");
								}
								else{
									$("#category2 option:selected").val(data);								
									$("[name=boardCodeNo]").val($("#category2").val());
								}
								
							}
						});//end of ajax
}	




</script>


</html>


<%@ include file="/WEB-INF/views/common/footer.jsp" %>
