window.Directory={panel:$(".sited-file-directory"),form:$("#form"),init:function(){$(document).on("click",".sited-directory-create-handler",function(i){this.show()}.bind(this)),$(".sited-file-directory__close").click(function(){this.hide()}.bind(this)),$("#submit").click(function(){this.submit(this.serializeToObject())}.bind(this))},submit:function(i){Directory.validate(i)&&$.ajax({url:"/web/api/directory",method:"POST",data:JSON.stringify(i),contentType:"application/json",dataType:"json"}).then(function(){window.location.reload()}).fail(function(i){alert("Save failed")})},validate:function(i){var e=i.path;return 0!==e.indexOf("/")||e.lastIndexOf("/")!==e.length-1?(alert("path is not legal, example: /XXX/"),!1):!!i.displayName||(alert("please enter displayName"),!1)},serializeToObject:function(){for(var i=Directory.form.serializeArray(),e={},t=0;t<i.length;t+=1){const n=i[t];if(-1!==n.name.indexOf(".")){var a=n.name.split(".");void 0===e[a[0]]&&(e[a[0]]={}),void 0===e[a[0]][a[1]]&&(e[a[0]][a[1]]=[]),e[a[0]][a[1]].push(n.value)}else e[n.name]=n.value}return e},show:function(){this.panel.addClass("show"),this.expand()},hide:function(){this.panel.removeClass("show")},expand:function(){this.panel.addClass("expand")}},Directory.init();