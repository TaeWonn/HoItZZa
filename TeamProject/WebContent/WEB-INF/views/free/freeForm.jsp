<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="../common/error.jsp"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<link href="https://fonts.googleapis.com/css?family=Gothic+A1|Noto+Sans+KR&display=swap" rel="stylesheet">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/header.css" /> 
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/board/boardWrite.css" /> 
<style>
#userId{
	margin-left: 6px;
}
div#img-viewer img{max-width: 450px;max-height: 600px;}
</style>
<article id="article">

	<div id="freeBoard">
	<form action="<%=request.getContextPath()%>/free/freFormEnd"
	 method="post" enctype="multipart/form-data" >
			<h3 style="text-align: center; margin:0 auto; padding: 20px 0 0 0;">자유게시판  작성</h3>
				<br>
	        	<input type="text" class="alert alert-light" role="alert" name="boardTitle" id="boardTitle" placeholder="제목을 입력해주세요">
	        	<br>
	       	 <input type="text" class="alert alert-light" role="alert" name="boardWriter" id="userId" value="<%=userLoggedIn.getUserId() %>" readonly > 
	        <br>
	
	        <select class="custom-select" id="boardCodeNo" name="boardCodeNo">
	                <option selected>게시판 선택</option>
	                <option value="FC_">잡담 게시판</option>
	                <option value="FU_">유용한 생활지식 게시판</option>
	                <option value="FE_">연예/미디어 게시판</option>
	                <option value="FS_">나눔게시판</option> 
	        </select>
	        <br>
	        <!-- <div id="img-viewer-container">
							<img id="img-viewer" width=350/>
						</div> -->
	        <div contentEditable="true"  id="boardContent" >
	        
	        
	        	<div id="img-viewer" style="display: block;"></div>

	        
	        </div><br>
        
        <div class="filebox">			
			<input type="file"  id="ex_img" onchange="loadImg(this);" name="imgFile">			 
		   <label for="ex_img">이미지삽입</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		    <input type="file"  id="ex_filename" class="upload-hidden"name="upFile" > 
		    
		  <input class="upload-name" value="파일명" disabled="disabled" >
		  
		  <label for="ex_filename">파일 업로드</label>
		 <!--  <input type="file"  id="ex_filename2" class="upload-hidden"  > -->
		  <input type="hidden" name="boardContent" id="cont" />
		</div>
          
                <div id="buttons">
                  <button type="submit" class="btn btn-success" onclick="return validate();" value="버튼">등록</button>
                  <button type="button" class="btn btn-outline-danger" onclick="">취소</button>
                </div>
            </form>
       </div> <!-- div#frrBoard End -->


<script>

function validate(){
	//내용
	var boardContent = document.getElementById('boardContent').textContent.trim();
	console.log('컨텐츠'+boardContent);
	if(boardContent.length == 0){
		alert("내용을 입력하세요.");
		return false;
	}else{
		$('#cont').val(boardContent);
	}
	console.log('밸류'+$('#cont').val());
	//제목
	var boardTitle = $("[name=boardTitle]").val();
	if(boardTitle.trim().length == 0){
		alert("제목을 입력하세요.");
		return false;
	}

	
	
	return true;
}

var sel_file=[];
function loadImg(f){
	console.log($('#ex_img').val());
	console.log($('#ex_filename').val());
	var files=Array.prototype.slice.call(f.files);
	
	files.forEach(function(f){
		sel_file.push(f);
		var reader = new FileReader();
		reader.onload = function(e){
			//result속성에는 파일컨텐츠 담겨있음.
		 	$("#img-viewer").append('<img src="'+reader.result+'" alt="" />').css('width','300px')
							.css('max-height','300px')
							.css('max-width','400px')
							.css('height','300px')
							.css('position','relative')
							.css('left','10px')
							.css('top','6px');
		}
		reader.readAsDataURL(f);
		
		
	});
	
	
	
	
	
	
	
	
	
	
	
	
	/* console.log(f.files[0]);//File 실제 업로드한 파일
	for(var i=0;i<f.files.length;i++){
			
		var reader = new FileReader();
		//파일읽기메소드 호출. 읽기완료하면 onload에 등록된 함수를 호출
		console.log(f.files[i]);
		console.log('파일객체');
		reader.readAsDataURL(f.files[i]);
		reader.onload = function(){
			console.log(reader);
			//result속성에는 파일컨텐츠 담겨있음.
			/* $("#img-viewer").append(attr("src", reader.result).css('width','300px') */
		/* 	$("#img-viewer").append('<img src="'+reader.result+'" alt="" />').css('width','300px')
							.css('max-height','300px')
							.css('max-width','500px')
							.css('height','300px')
							.css('position','relative')
							.css('left','10px')
							.css('top','6px');
			console.log(f.files[i]);
			console.log('어펜드');
		}
	 }   */
}
 



var fileTarget = $('.filebox .upload-hidden');

fileTarget.on('change', function(){ // 값이 변경되면
	var files=document.getElementById('ex_filename');
	var maxPostSize = 1024 * 1024 * 30;
	for(var i=0;i<files.files.length;i++){
		var fileSize=document.getElementById('ex_filename').files[0].size;
		if(fileSize>maxPostSize){
			alert('파일 크기는 '+(maxPostSize/1024/1024)+"MB를 넘길 수 없습니다.");
			fileTarget.val('');
			return;
		}
	}
	
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

</article>


<%@ include file="/WEB-INF/views/common/footer.jsp" %>
