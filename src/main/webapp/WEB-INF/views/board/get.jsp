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



                    <div class="form-group">
                        <label>Bno</label> <input class="form-control" name='bno'
                                                  value = '<c:out value="${boardDTO.bno}"/>'  readonly = "readonly">
                    </div>

                    <div class="form-group">
                        <label>Title</label> <input class="form-control" name='title'
                                                    value = '<c:out value="${boardDTO.title}"/>' readonly = "readonly">
                    </div>

                    <div class="form-group">
                        <label>Text area</label>
                        <textarea class="form-control" rows="3" name='content' readonly = "readonly">
                            <c:out value="${boardDTO.content}"/></textarea>
                    </div>

                    <div class="form-group">
                        <label>Writer</label> <input class="form-control"
                                                     name='writer' value='<c:out value="${boardDTO.writer}"/>' readonly="readonly">
                    </div>
                    <button data-oper="modify" class="btn btn-default">수정하기</button>
                    <button data-oper="list" class = "btn btn-info">List</button>
<%--                    나중을 위해서 링크를 거는게아니라 javascript로 바꿈--%>

<%--                    <form id ='operForm' action="/board/modify" method="get">--%>
<%--                        <input type = 'hidden' id='bno' name='bno' value ='<c:out value="${boardDTO.bno}"/>'>--%>
<%--                    </form>--%>


            </div>
            <!--  end panel-body -->

        </div>
        <!--  end panel-body -->
    </div>
    <!-- end panel -->
</div>
<!-- /.row -->

<script type="text/javascript">
    $(document).ready(function(){
        // var operForm = $("#operForm");
        $("button[data-oper='modify']").on("click", function(e){
            self.location = `/board/modify?bno=${boardDTO.bno}&${pageRequestDTO.link}`
        });

        $("button[data-oper='list']").on("click", function(e) {
            self.location = "/board/list?${pageRequestDTO.link}"
            //list버튼을 눌렀을때 원래의 페이지로 돌아감
        });
    });
</script>
<%@include file="../includes/footer.jsp"%>
