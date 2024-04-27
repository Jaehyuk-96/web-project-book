<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="../includes/header.jsp"%>


<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">게시물보기</h1>
    </div>
    <!-- /.col-lg-12 -->
</div>
<!-- /.row -->

<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default">

            <div class="panel-heading">게시물보기</div>
            <!-- /.panel-heading -->
            <div class="panel-body">

                <form role="form" action="/board/modify" method="post">

                    <input type = "hidden" name="page" value="${pageRequestDTO.page}">
                    <input type = "hidden" name="size" value="${pageRequestDTO.size}">

                    <div class="form-group">
                        <label>Bno</label> <input class="form-control" name='bno'
                                                  value = '<c:out value="${boardDTO.bno}"/>'  readonly = "readonly">
                    </div>

                    <div class="form-group">
                        <label>Title</label> <input class="form-control" name='title'
                                                    value = '<c:out value="${boardDTO.title}"/>' >
                    </div>

                    <div class="form-group">
                        <label>Text area</label>
                        <textarea class="form-control" rows="3" name='content'>
                            <c:out value="${boardDTO.content}"/></textarea>
                    </div>

                    <div class="form-group">
                        <label>Writer</label> <input class="form-control"
                                                     name='writer' value='<c:out value="${boardDTO.writer}"/>' readonly = "readonly">
                    </div>
                    <button type ="submit" data-oper="modify" class="btn btn-default" >수정하기</button>
                    <button type ="submit" data-oper="remove" class="btn btn-default" >삭제하기</button>
                    <button type="submit" data-oper="list" class="btn btn-default" >게시판가기</button>
                </form>

            </div>
            <!--  end panel-body -->

        </div>
        <!--  end panel-body -->
    </div>
    <!-- end panel -->
</div>
<!-- /.row -->

<script type="text/javascript">
    //자바스크립트를 이용하여 버튼클릭시 url이동
    //버튼세개를 modify를 눌렀을때는 submit되고 그외에 눌렀을때 처리를 위해 javascript사용
    $(document).ready(function(){
        var formObj = $("form");

        $('button').on("click", function(e){

            e.preventDefault();

            var operation = $(this).data("oper");

            console.log(operation);

            if(operation === "remove"){
                formObj.attr("action", "/board/remove");
            }else if(operation === "list"){
                self.location = "/board/list?${pageRequestDTO.link}"
                return;
            }
            formObj.submit();
        })
    })
</script>

<%@include file="../includes/footer.jsp"%>


