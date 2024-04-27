<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<%@include file="../includes/header.jsp"%>
<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">Tables</h1>
    </div>
    <!-- /.col-lg-12 -->
</div>
<!-- /.row -->

<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default">
            <div class="panel-heading">
                게시판
                <button id = "regBtn" type = "button" class = "btn btn-xs pull-right">게시물 등록하기</button>
            </div>



            <!-- /.panel-heading -->
            <div class="panel-body">
                <table class="table table-striped table-bordered table-hover">
                    <thead>
                    <tr>
                        <th>#번호</th>
                        <th>제목</th>
                        <th>작성자</th>
                        <th>작성일</th>
                        <th>수정일</th>
                    </tr>
                    </thead>
                    <c:forEach items = "${pageResponseDTO.dtoList}" var="boardDTO">
                        <tr>
                        <th><c:out value ="${boardDTO.bno}"/></th>
                            <td><a href="/board/get?bno=${boardDTO.bno}&${pageRequestDTO.link}" class="text-decoration-none" data-bno="${boardDTO.bno}"><c:out value ="${boardDTO.title}"/></a></td>

                        <td><c:out value ="${boardDTO.writer}"/></td>
                        <td><fmt:formatDate pattern = "yyyy-MM-dd" value = "${boardDTO.regDate}"/></td>
                        <td><fmt:formatDate pattern = "yyyy-MM-dd" value = "${boardDTO.updateDate}"/></td>
                        </tr>
                    </c:forEach>
                </table>
                <!--모달창 추가-->
                <div class="modal fade" id="myModal" tabindex="-1" role="dialog"
                     aria-labelledby="myModalLabel" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal"
                                        aria-hidden="true">&times;</button>
                                <h4 class="modal-title" id="myModalLabel">Modal title</h4>
                            </div>
                            <div class="modal-body">처리가 완료되었습니다.</div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default"
                                        data-dismiss="modal">Close</button>
                                <button type="button" class="btn btn-primary">Save
                                    changes</button>
                            </div>
                        </div>
                        <!-- /.modal-content -->
                    </div>
                    <!-- /.modal-dialog -->
                </div>
                <!-- /.modal -->

            </div>
        </div>
    </div>
</div>

<div class = "float-end">
    <ul class="pagination flex-wrap">
        <c:if test = "${pageResponseDTO.prev}">
            <li class = "page-item">
                <a class = "page-link" data-num ="${pageResponseDTO.start - 1}">Previous</a>
            </li>
        </c:if>
        <c:forEach begin = "${pageResponseDTO.start}" end = "${pageResponseDTO.end}" var="num">
            <li class = "page=item ${pageResponseDTO.page == num? "active":""}"><a class = "page-link" data-num = "${num}" >${num}</a></li>
        </c:forEach>

        <c:if test = "${pageResponseDTO.next}">
            <li class = "page-item">
                <a class = "page-link" data-num = "${pageResponseDTO.end + 1}">Next</a>
            </li>
        </c:if>
    </ul>
</div>

<div>
    <button id="showSearchButton">검색</button>
</div>

<div class = "row content" style="display: none">
    <div class = "card">
        <div class = "card-body">
            <h5 class = "card-title">Search</h5>
            <form action = "/board/list" method="get">
                <input type = "hidden" name="size" value = "${pageRequestDTO.size}">
                <div class = "mb-3">
                    <input type = "checkbox" name = "types" value="t" ${pageRequestDTO.checkType("t")?"checked":""}>제목
                    <input type = "checkbox" name = "types" value="w" ${pageRequestDTO.checkType("w")?"checked":""}>작성자
                    <input type = "text" name = "keyword" class = "form-control" placeholder="내용을 입력하세요"
                           value='<c:out value="${pageRequestDTO.keyword}"/>'>
                </div>
                <div class = "input-group mb-3 dueDateDiv">
                    <input type = "date" name="from" class = "form-control" value="${pageRequestDTO.from}">
                    <input type = "date" name="to" class = "form-control" value="${pageRequestDTO.to}">
                </div>
                <div class = "input-group mb-3">
                    <div class = "float-end">
                        <button class = "btn btn-primary" type="submit">검색</button>
                        <button class = "btn btn-info clearBtn" type="reset">초기화</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>

<script type = "text/javascript">
    $(document).ready(function(){
        var result = '<c:out value = "${result}"/>';

        checkModal(result);

        history.replaceState({}, null, null);

        function checkModal(result) {
            if(result ==='' || history.state) {//뒤로가기시 다시 등록되지 않기위해서 사용
                return;
            }
            if(parseInt(result)>0) {
                $(".modal-body").html("게시글" +parseInt(result) + "번이 등록되었습니다.");
            }

            $("#myModal").modal("show");
        }

        $("#regBtn").on("click", function(){
            self.location="/board/register";
        });

    });


</script>


<script>
<%--    페이징처리--%>

document.querySelector(".pagination").addEventListener("click", function (e) {
    e.preventDefault()
    e.stopPropagation()

    const target = e.target

    if(target.tagName !== 'A') {
        //a태그를 클릭했을경우만
        return
    }
    const num = target.getAttribute("data-num")
    //data-num 속성값을 읽어옴

    //페이징 버튼 클릭시 검색 조건 유지시키기
    const formObj = document.querySelector("form")

    formObj.innerHTML += `<input type = 'hidden' name = 'page' value = '\${num}'>`

    formObj.submit();},false)
// 백틱을 사용하면 문자열 결합에 +를 이용해야 하는 불편함을 줄임


</script>

<script>
    // HTML 요소를 가져옵니다.
    const searchButton = document.getElementById('showSearchButton');
    const searchForm = document.querySelector('.row.content');

    // Search 버튼 클릭 시 이벤트를 처리합니다.
    searchButton.addEventListener('click', function(event) {
        // 검색 폼의 현재 표시 상태를 확인합니다.
        const isFormVisible = searchForm.style.display !== 'none';

        // 표시 상태를 변경합니다.
        if (isFormVisible) {
            searchForm.style.display = 'none'; // 숨김
        } else {
            searchForm.style.display = 'block'; // 표시
        }
    });
</script>

<script>
    document.querySelector(".clearBtn").addEventListener("click", function(e){
        e.preventDefault()
        e.stopPropagation()

        self.location = '/board/list'
    },false)
</script>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>

<%@include file="../includes/footer.jsp"%>
