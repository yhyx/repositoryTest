<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- 引入样式 -->
<link rel="stylesheet" href="https://unpkg.com/element-ui/lib/theme-chalk/index.css">
</head>
<body>
 <div id="app">
	<template>
	  <el-table
	    ref="multipleTable" border
	    :data="tableData" tooltip-effect="dark"
	    style="width: 100%" @selection-change="handleSelectionChange">
	    <el-table-column
	      type="selection"
	      width="55">
	    </el-table-column>
	    <el-table-column
	      prop="id"
	      label="序号"
	      width="120">
	       <template slot-scope="scope" >
           		<el-input  v-model="scope.row.id"  placeholder="请输入内容"></el-input>
      	   </template>
	    </el-table-column>
	    <el-table-column
	      prop="name"
	      label="姓名"
	      width="120">
	    </el-table-column>
	    <el-table-column
	      prop="age"
	      label="年龄"
	      show-overflow-tooltip>
	    </el-table-column>
	    <el-table-column
	      fixed="right"
	      label="操作"
	      width="300">
	      	<template slot-scope="scope">
		       <el-button size="mini" @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
     		</template>
	    </el-table-column>
	  </el-table>
	  <div style="margin-top: 20px">
	    <el-button @click="toggleSelection([tableData3[1], tableData3[2]])">新增</el-button>
	    <el-button @click="toggleSelection()">删除所选</el-button>
	  </div>
	</template>
 </div>
</body>
 <!-- 先引入 Vue -->
 <script src="https://unpkg.com/vue/dist/vue.js"></script>
 <!-- axios -->
 <script src="https://unpkg.com/axios/dist/axios.min.js"></script>
 <!-- 引入组件库 -->
 <script src="https://unpkg.com/element-ui/lib/index.js"></script>
<script>
	new Vue({
	    el: '#app',
	    data(){
	        return {
	            tableData: []
	        }
	    },
	    created: function () {
	        var data = []
	        let url = '${pageContext.request.contextPath}/teacher/queryTeacherData'
	        Vue.prototype.$http = axios;
	        let _this = this
	        this.$http.post(url, {}).then(function (res) {
	        	console.log(res);
	            for (let i = 0; i < res.data.length; i++) {
	            	console.log(res);
	                var obj = {}
	                obj.id = res.data[i].tid
	                obj.name = res.data[i].name
	                obj.age = res.data[i].age
	                data[i] = obj
	            }
	            _this.tableData = data
	        }).catch(function (error) {

	        })
	    },
	    methods: {
		      toggleSelection(rows) {
		        if (rows) 
		          rows.forEach(row => {
		            this.$refs.multipleTable.toggleRowSelection(row);
		          });
		        } else {
		          this.$refs.multipleTable.clearSelection();
		        }
		      },
		      handleSelectionChange(val) {
		        this.multipleSelection = val;
		      },
		      handleEdit(index, row) {
		          console.log(index, row);
		      }
		    }
	})	
</script>
<!-- style="border:none!important;background-color:transparent;width:70px;height:30px; text-align: center;margin-left:15px;" -->
<style>
	.el-input__inner{
		border:none!important;
		background-color:transparent;
		text-align: center;
	}
	.el-input__inner:focus{
		border:1px solid #dcdfe6!important;
		border-color:#409EFF!important;
	}
	

</style>
</html>