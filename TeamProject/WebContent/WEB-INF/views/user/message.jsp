<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/index.css" />
<link href="https://fonts.googleapis.com/css?family=Gothic+A1|Noto+Sans+KR&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
   <link rel="stylesheet" href="<%=request.getContextPath()%>/css/message.css" />


</head>
<body>  
 
    <h2 style="text-align: center">쪽지함</h2>
        <table class="table">
                <thead class="thead-light">
                  <tr>
                    <th scope="col">발신인</th>
                    <th scope="col">내용</th>
                    <th scope="col">작성일자</th>
                    <th scope="col">Handle</th>
                  </tr>
                </thead>
                <tbody>
                  <tr>
                    <th scope="row">작성자명</th>
                    <td>Mark</td>
                    <td>Otto</td>
                    <td>
                        <button type="button" class="btn btn-secondary" onclick="deletemsg();">삭제</button>
                          
                        <button type="button" class="btn btn-secondary" onclick="reply();" value="gg">답장</button>
                    </td>
                  </tr>
                  <tr>
                    <th scope="row">작성자명</th>
                    <td>Jacob</td>
                    <td>Thornton</td>
                    <td>                        
                        <button type="button" class="btn btn-secondary" onclick="deletemsg();">삭제</button>
                          
                        <button type="button" class="btn btn-secondary" onclick="reply();">답장</button>
                    </td>
                  </tr>
                  <tr>
                    <th scope="row">작성자명</th>
                    <td>Larry</td>
                    <td>the Bird</td>
                    <td>
                            <button type="button" class="btn btn-secondary" onclick="deletemsg();">삭제</button>
                          
                            <button type="button" class="btn btn-secondary" onclick="reply();">답장</button>
                    </td>
                  </tr>
                  <tr>
                        <th scope="row">작성자명</th>
                        <td>Larry</td>
                        <td>the Bird</td>
                        <td>
                                <button type="button" class="btn btn-secondary" onclick="deletemsg();">삭제</button>
                          
                                <button type="button" class="btn btn-secondary" onclick="reply();">답장</button>
                        </td>
                      </tr>
                      <tr>
                            <th scope="row">작성자명</th>
                            <td>Larry</td>
                            <td>the Bird</td>
                            <td>
                                    <button type="button" class="btn btn-secondary" onclick="deletemsg();">삭제</button>
                          
                                    <button type="button" class="btn btn-secondary" onclick="reply();">답장</button>
                            </td>
                        </tr> 
                        
                </tbody>
                
              </table>
              <br><br>
              <table class="table2">
                    <thead class="thead-light">
                      <tr>
                        <th scope="col">날짜</th>
                        <th scope="col">메세지</th>
                        <th scope="col">수신인</th>
                        <th scope="col">발신인</th>
                        <th scope="col"><button type="button" class="btn btn-outline-danger">삭제</button></th>
                      </tr>
                    </thead>
                    <tbody>
                      <tr>
                        <th scope="row">작성자명</th>
                        <td>Mark</td>
                        <td>Otto</td>
                        <td></td>
                        <td><input type="checkbox" name="" id="" class="del_check"></td>
                      </tr>
                      <tr>
                        <th scope="row">작성자명</th>
                        <td>Jacob</td>
                        <td>Thornton</td>
                        <td> </td>
                        <td><input type="checkbox" name="" id="" class="del_check"></td>
                      </tr>
                      <tr>
                        <th scope="row">작성자명</th>
                        <td>Larry</td>
                        <td>the Bird</td>
                        <td></td>
                        <td><input type="checkbox" name="" id="" class="del_check"></td>
                      </tr>
                      <tr>
                            <th scope="row">작성자명</th>
                            <td>Larry</td>
                            <td>the Bird</td>
                            <td> </td>
                            <td><input type="checkbox" name="" id="" class="del_check"></td>
                          </tr>
                          <tr>
                                <th scope="row">작성자명</th>
                                <td>Larry</td>
                                <td>the Bird</td>
                                <td></td>
                                <td><input type="checkbox" name="" id="" class="del_check"></td>
                            </tr> 
                            
                    </tbody>
                    
                  </table>
</body>
</html>


<%@ include file="/WEB-INF/views/common/footer.jsp" %>
