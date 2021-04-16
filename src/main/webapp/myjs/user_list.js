var vm = new Vue({
    el:'#userdiv',
    data:{
        userlist:[],
        entity:{},
        dlist:[{postids:[]}],
        deptids:[]
    },
    methods:{
        getUserList:function () {
            var _this = this;
            axios.get("../user/getUserList.do").then(function (response) {
                _this.userlist = response.data;
            });
        },
        toUserDept:function (id) {
            //查出这个用户已经拥有的部门id，和全部部门，查询一个对象，完全可以，也可以把user丰富一下，直接查询一个user
            var _this = this;
            axios.get('../user/getUserVoById.do?id='+id).then(function (response) {
                _this.entity = response.data;
                _this.dlist = response.data.dlist;
                _this.deptids = response.data.deptids;
                document.getElementById("userdeptdiv").style.display="block";
            });
        },
        saveUserDept:function () {

            //把用户id和deptids传到后台，在service中，先删除后添加
            var _this = this;
            axios.post("../user/saveUserDept.do?id="+_this.entity.id,_this.deptids).then(function (response) {
                if(response.data.flag){
                    document.getElementById("userdeptdiv").style.display="none";
                    _this.getUserList();
                }else{
                    alert(response.data.msg);
                }
            });
        },
        toUserPost:function (id) {
            var _this = this;
            axios.get('../user/getUserInfo.do?id='+id).then(function (response) {
                _this.entity = response.data;
                _this.dlist = response.data.dlist;
                document.getElementById("userpostdiv").style.display="block";
            });
        },
        saveUserPost:function () {
            this.entity.dlist = this.dlist;
            var _this =this;
            axios.post('../user/saveUserPost.do',_this.entity).then(function (response) {
                if(response.data.flag){
                    alert(response.data.msg);
                    document.getElementById("userpostdiv").style.display="none";
                }else{
                    alert(response.data.msg);
                }
            });
        }
    },

    filters:{
        shijianfilter:function(value,args){
            var dt = new Date(value)

            var y = dt.getFullYear()

            //这里month得加1

            var m = dt.getMonth()+1

            var d = dt.getDate()

            //如果要求的时间格式只有年月日

            if(args.toLowerCase() === "yyy-mm-dd"){
                return `${y}-${m}-${d}`

                //如果时间要求精确到时分秒

            }else{
                var hh = dt.getHours()

                var mm = dt.getMinutes()

                var ss = dt.getSeconds();

                return `${y}-${m}-${d} ${hh}:${mm}:${ss}`

            }

        }

    },
});
vm.getUserList();
