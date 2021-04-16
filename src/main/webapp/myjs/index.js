var vm = new Vue({
    el:'#logindiv',
    data:{
        ub:{}
    },
    methods:{
        getLogin:function () {
            var _this = this;
            axios.post("user/getLogin.do",_this.ub).then(function (response) {
                if(response.data.flag){
                    location.href="pages/main.html";
                }else {
                    alert(response.data.msg);
                }

            });
        }
    }
});

window.onload = function(){
    var i3 = document.getElementsByClassName('input_3');
    for(var i=0;i<i3.length;i++){
        i3[i].onmouseover = function(){
            this.style.backgroundColor = "#23271F";
            this.style.color = "#fff";
        }
        i3[i].onmouseout = function(){
            this.style.backgroundColor = "#fff";
            this.style.color = "#23271F";
        }
    }
    var pass = document.getElementById("pwd");
    pass.onfocus = function(){
        pass.type = "pwd";
    }
}
