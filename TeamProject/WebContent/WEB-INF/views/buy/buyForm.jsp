<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>


<link href="https://fonts.googleapis.com/css?family=Gothic+A1|Noto+Sans+KR&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/boardForm.css" /> 
 
</head>

<body>


	<form action="<%=request.getContextPath()%>/buy/buyWriteEnd"
	 method="post" enctype="multipart/form-data">
	
		<h2 style="text-align: center">구매글 작성</h2>
		<br>
        <input type="text" class="alert alert-light" role="alert" name="boardTitle" id="boardTitle" placeholder="제목을 입력해주세요">
        <br>
        <input type="text" class="alert alert-light" role="alert" name="userId" id="userId" value="작성자명" readonly> 


<!-- 거래방식 -->
    	<select class="custom-select" id="boardDeal" name="boardDeal">

                <option value="1" selected>택배</option>
                <option value="2">직거래</option>
        </select>

        <br>

        <select class="custom-select" id="inputGroupSelect02" name="kategory">
                <option selected>카테고리 선택</option>
                <option value="1">식품</option>
                <option value="2">가전</option>
                <option value="3">패션</option>
        </select>
        <br>
        <!-- <div id="img-viewer-container">
						<img id="img-viewer" width=350/>
					</div> -->
        <div contentEditable="true"  id="boardContent">
        <img id="img-viewer" style="display: block;"/>
        
        </div>
        <br>
           <div class="filebox">
           			
					
	<input type="file" id="ex_img" onchange="loadImg(this);">			 
    <label for="ex_img">이미지삽입</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <input type="file" id="ex_filename" class="upload-hidden" >
    
  <input class="upload-name" value="파일명" disabled="disabled">
  <label for="ex_filename">파일 업로드</label>
  <input type="file" id="ex_filename" class="upload-hidden" name="">
</div>
          
                <div id="buttons">
                  <button type="submit" class="btn btn-success" onclick="return validate();" value="버튼">등록</button>
                  <button type="button" class="btn btn-outline-danger" onclick="">취소</button>
                </div>
            </form>

<script>

function validate(){
	//제목
	var boardTitle = $("[name=boardTitle]").val();
	if(boardTitle.trim().length == 0){
		alert("제목을 입력하세요.");
		return false;
	}
	//내용
	var boardContent = $("[name=boardContent]").val();
	if(boardContent.trim().length == 0){
		alert("내용을 입력하세요.");
		return false;
	}
	
	console.log("["+$("[name=boardContent]").val()+"]")
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



</script>

</body>
</html>


<%@ include file="/WEB-INF/views/common/footer.jsp" %>
