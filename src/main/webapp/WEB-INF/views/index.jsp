<%--
  Created by IntelliJ IDEA.
  User: LIANGBE
  Date: 8/11/2016
  Time: 3:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-3.1.0.js"></script>--%>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/ext-all-debug.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/theme-neptune-all-debug.css">
<html>
<head>
    <title>Title</title>
</head>
<script>
    Ext.onReady(function(){

        Ext.define('User', {
            extend: 'Ext.data.Model',
            fields: [
                { name: 'id' ,type: 'int'},
                { name: 'age', type: 'int' },
                { name: 'name', type: 'string' },
                { name: 'firstName',  type: 'string' },
                { name: 'sequence',type: 'int' },
                { name: 'address',type: 'auto' },
                { name: 'educationList',type: 'auto' }

            ],
        });
        var store = new Ext.data.JsonStore({
            // store configs
            storeId: 'myStore',
            autoLoad:true,
            model:'User',
            proxy: {
                type: 'ajax',
                url: "${pageContext.request.contextPath }/api/user",
                reader: {
                    type: 'json',
                    totalProperty: 'totalElements',
                    rootProperty: 'content'
                }
            },
            //alternatively, a Model name can be given (see Ext.data.Store for an example)
        });
        Ext.create('Ext.grid.Panel', {
            title: 'Simpsons',
            store: store,
            id:'myGridPanel',
            columns: [
                {
                    text: 'Age',
                    dataIndex: 'age',
                    flex:1,
                },
                {
                    text: 'Code',
                    dataIndex: 'code',
                    flex:1,
                },
                {
                    text: 'Description',
                    dataIndex: 'description',
                    flex:1,
                },
                {
                    text: 'Sequence',
                    dataIndex: 'sequence',
                    flex:1,
                }
            ],
            height: 500,
            width: 1000,
            dockedItems : [
                {
                    xtype : 'toolbar',
                    dock : 'top',
                    items : [
                        {
                            xtype : 'button',
                            id : 'addBtn',
                            text : 'Add'
                        },
                    ],
                },
            ],
            renderTo: Ext.getBody()
        });
        Ext.getCmp("addBtn").on("click",function(btn){
            store.insert ( 0 ,  Ext.create('TypeSupp', {}) );
            Ext.getCmp("myGridPanel").getPlugin ( 'myplugin').startEdit(0,0);
        });
        Ext.getCmp("myGridPanel").on("edit",function( editor , context ){
            var record= context.record;
            debugger;
        });
    });
    <%--    $(document).ready(function(){
        $("#submit").click(function(){
            var inputName=$("#name").val();
            debugger;
            $.ajax({
                url:"${pageContext.request.contextPath }/myController",
                dataType: 'json',
                async:false,
                data: {"name":inputName},
                type: "GET",
                success: function(req) {
                    debugger;
                    var tr=null;
                    $.each(req, function (i, item) {
                        tr = "<tr><td>"+item.id+"</td>" +
                                "<td>"+item.category+"</td>" +
                                "<td>"+item.code+"</td>" +
                                "<td>"+item.description+"</td>" +
                                "<td>"+item.sequence+"</td></tr>";
                        debugger;
                        $("#grid").append(tr);
                    })
                },
                error: function() {
                    debugger;
                }
            });
        });
   });--%>
</script>
<body>
<%--<form >--%>
<%--<input name="name" id="name"/>--%>
<%--<button  id="submit" type="button">提交</button>--%>
<%--</form>--%>

<%--<table border="1" id="grid">--%>
<%--<tr id="header">--%>
<%--<th id="id">No.</th>--%>
<%--<th id="category">Category</th>--%>
<%--<th id="code">Code</th>--%>
<%--<th id="description">Description</th>--%>
<%--<th id="sequence">Sequence</th>--%>
<%--</tr>--%>

<%--</table>--%>
</body>
</html>
