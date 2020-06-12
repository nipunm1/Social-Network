var app = angular.module("myApp",["ngRoute"])
app.config(function($routeProvider){
	$routeProvider
	.when("/",{
		 templateUrl : "home.htm"
	})
	.when("/register",{
		 templateUrl : "register.htm"
	})
	.when("/login",{
		 templateUrl : "login.htm"
	})
	.when("/profile",{
		 templateUrl : "profile.htm"
	})
	.when("/blog",{
		 templateUrl : "blog.htm"
	})
	.when("/allblog",{
		 templateUrl : "allblog.htm"
	})
	.when("/h",{
		 templateUrl : "profile.htm"
	})
	.when("/myprofile",{
		 templateUrl : "myprofile.htm"
	})
	.when("/allusermultimedia",{
		 templateUrl : "allusermultimedia.htm"
	})
	.when("/addfriends",{
		 templateUrl : "addfriends.htm"
	})
	.when("/friends",{
		 templateUrl : "friends.htm"
	})
	.when("/chat",{
		templateUrl : "chat.htm"
	});
});




app.controller("homectrl",function($scope,$rootScope,$http,$location){
$rootScope.showtitle = "t";
   $scope.logoutbtn = function(){
	   $http({
		   method : "GET",
		   url : "http://localhost:8485/middleware.project2/userByEmail?useremail="+$rootScope.rootuser.userEmail+""
	   }).then(function mySuccess(response){
		   $http({
			   method : "GET",
			   url : "http://localhost:8485/middleware.project2/logoutUser?useremail="+$rootScope.rootuser.userEmail+""
		   }).then(function mySuccess(response){
			   $scope.loginstatuschangeno = response.data;
		   },
		   function myError(response){
			   $scope.loginstatuschangeno = response.statusText;
		   });
		   $rootScope.rootuser = "";
		   $location.path("/login");
		},
	   function myEroor(response){
		   alert("wrong url");
		});
   }
});






app.controller("profilectrl",function($scope,$rootScope,$http){
	$scope.usermultimediaimage = function(){
		$http({
			method : "GET",
			url : "http://localhost:8485/middleware.project2/usermultimediaByUserEmail?useremail="+$rootScope.rootuser.userEmail
		}).then(function mySuccess(response){
			$rootScope.userimage = response.data;
		},
		function myError(response){
			$rootScope.userimage = response.statusText;
		});
	}
	$scope.usermultimediaimage();
});

app.controller("registerctrl",function($scope,$rootScope,$http){
	$rootScope.showtitle = "";
	$scope.registerbtn = function(){
		var email = $scope.u_email;
		var pass = $scope.u_pass;
		var pass1 = $scope.u_pass1;
		var name = $scope.u_name;
		var address = $scope.u_address;
		var number = $scope.u_num;
		var number1 = document.getElementById("u_num");
		if(!email){
			alert("please enter email");
			return false;
		}
		else if(!pass){
			alert("please enter password");
			return false;
		}
		else if(!pass1){
			alert("please confirm password");
			return false;
		}
		else if(!name){
			alert("please enter name");
			return false;
		}
		else if(!address){
			alert("please enter address");
			return false;
		}
		else if(!number){
			alert("please enter number");
			return false;
		}
		else if(pass != pass1){
			alert("Confirm password must be same as password");
			return false;
		}
		else if(number1.value.length>10 || number1.value.length<10){
			alert("please enter 10 digit valid mobile number");
			return false;
		}
		$http({
			method : "GET",
			url : "http://localhost:8485/middleware.project2/addUser?useremail="+email+"&userpassword="+pass+"&username="+name+"&useraddress="+address+"&usernumber="+number+"&userenabled=0"
		}).then(function mySuccess(response){
		$scope.responsedata = response.data;
		alert("You are Successfully registered now log in");
		},
		function myError(response){
		$scope.responsedata = response.statusText;	
		});
	}
});

app.controller("loginctrl",function($scope,$rootScope,$http,$location){
	$rootScope.showtitle = "";
	$scope.loginbtn = function(){
		var e_mail = $scope.log_email;
		var e_pass = $scope.log_pass;
		if(!e_mail){
			alert("please enter email address");
			return;
		}
		else if(!e_pass){
			alert("please enter password");
			return;
		}
		else
			{
		$http({
			method : "GET",
			url : "http://localhost:8485/middleware.project2/userByEmail?useremail="+e_mail+""
		}).then(function  mySuccess(response)
		{   
			var response_data = response.data;
			if(response_data.userPassword == e_pass)
		    	{
		        $rootScope.rootuser=  response_data;
		        $location.path("/profile");
		        $http({
		        	method : "GET",
		        	url : "http://localhost:8485/middleware.project2/loginUser?useremail="+$rootScope.rootuser.userEmail+""
		        }).then(function mySuccess(response){
		        $scope.loginstatuschangeyes = response.data;	
		        },
		        function myError(response){
		        $scope.loginstatuschangeyes = response.statusText;	
		        });
		        }
		    else
		    	{
		    	 alert("Invalid Email or  Password");
		    	 $rootScope.rootuser=null;
		    	}
		},
		function myError(response){
			$rootScope.rootuser={};
		});
	}
}
}); 

app.controller("blogctrl",function($scope,$rootScope,$http){
	
     $scope.showallblog = function()
	{
		$http({
			method : "GET",
			url : "http://localhost:8485/middleware.project2/blogByUserEmail?useremail="+$rootScope.rootuser.userEmail+""
		}).then(function mySuccess(response){
			$scope.responsegetblogbyuseremail = response.data;
		},
		function myError(response){
			$scope.responsegetblogbyuseremail = response.statusText;
		});
	}
	
	$scope.showallblog();
	
	$scope.addblogbtn = function(){
		var blog_name = $scope.b_name;
		var blog_status = $scope.b_status;
		var blog_comment = $scope.b_comment;
		if(!blog_name){
			alert("Enter Blog Name");
			return;
		}
		else if(!blog_status){
			alert("Enter Blog Status");
			return;
		}
		else if(!blog_comment){
			alert("Enter Blog Comment");
			return;
		}
		else{
		 $http({
				method : "GET",
				url : "http://localhost:8485/middleware.project2/addBlog?blogcomment="+blog_comment+"&useremail="+$rootScope.rootuser.userEmail+"&bloglikes=0&blogdislikes=0&blogtype=0&blogname="+blog_name+"&blogstatus="+blog_status+""
			}).then(function mySuccess(response){
				$scope.responsedata = response.data;
				$scope.showallblog();
				alert("new blog added");
			},
			function myError(response){
				$scope.responsedata = response.statusText;
			});
		}
		}
	
	$scope.deleteblogbtn = function(blogid){
		$http({
			method : "GET",
			url : "http://localhost:8485/middleware.project2/deleteBlog?blogid="+blogid+""
		}).then(function mySuccess(response){
		 $scope.responsedeleteblog = response.data;	
		 $scope.showallblog();
		 alert("blog deleted");
		},
		function myError(response){
		 $scope.responsedeleteblog = response.statusText;
		});
	}
	
	$scope.editblogbtn = function(blogid){
		$http({ 
			method : "GET",
			url : "http://localhost:8485/middleware.project2/blogById?BlogId="+blogid+""
		}).then(function mySuccess(response){
		 $rootScope.responseeditblog = response.data;
		 $scope.b_name = $rootScope.responseeditblog.blogName;
		 $scope.b_status = $rootScope.responseeditblog.blogStatus;
		 $scope.b_comment = $rootScope.responseeditblog.blogComment;
		},
		function myError(response){
		 $rootScope.responseeditblog = response.statusText;
		});
	}
	
	$scope.updateblogbtn = function(){
		var upb_name = $scope.b_name;
		var upb_comment = $scope.b_comment;
		var upb_status = $scope.b_status;
		$http({
			method : "GET",
			url : "http://localhost:8485/middleware.project2/updateBlog?blogid="+$rootScope.responseeditblog.blogId+"&blogname="+upb_name+"&blogcomment="+upb_comment+"&blogstatus="+upb_status+"&useremail="+$rootScope.rootuser.userEmail+""
		}).then(function mySuccess(response){
			$scope.responseupdateblog = response.data;
			$scope.showallblog();
			alert("blog updated");
		},
		function myError(response){
			$scope.responseupdateblog = response.statusText;
		});
	}
	
	$scope.backtoaddblogbtn = function(){
		$scope.addblogbtn();
		$scope.showallblog();
	}
	
	$scope.likebtn = function(blogid)
	{
		$http({
		method : "GET",
		url : "http://localhost:8485/middleware.project2/addBlogLike?BlogId="+blogid+""
		}).then(function mySuccess(response)
		{
			$scope.responseaddbloglike = response.data;
			$scope.showallblog();
		},
		function myError(response){
			$scope.responseaddbloglike = response.statusText;
		});
	}
	
	$scope.dislikebtn = function(blogid){
		$http({
			method : "GET",
			url : "http://localhost:8485/middleware.project2/addBlogDisLike?BlogId="+blogid+""
		}).then(function mySuccess(response){
			$scope.responseaddblogdislike = response.data;
			$scope.showallblog();
		},
		function myError(response){
			$scope.responseaddblogdislike = response.statusText;
		});
	}
});

app.controller("allblogctrl",function($scope,$rootScope,$http){
	
	$scope.allotheruserblogbtn = function(){
		$http({
			method : "GET",
			url : "http://localhost:8485/middleware.project2/allOtherUserBlog?useremail="+$rootScope.rootuser.userEmail+""
		}).then(function mySuccess(response){
			$rootScope.responseallusersblog = response.data;
		},
		function myError(response){
			$rootScope.responseallusersblog = response.statusText;
		});
	}
	$scope.allotheruserblogbtn();
	$scope.alluserlikebtn = function(blogid){
		$http({
		method : "GET",
		url : "http://localhost:8485/middleware.project2/addBlogLike?BlogId="+blogid+""
		}).then(function mySuccess(response){
			$scope.responsealluserlike = response.data;
			$scope.allotheruserblogbtn();
		},
		function myError(response){
			$scope.responsealluserlike = response.statusText;
		});
	}
	
	$scope.alluserdislikebtn = function(blogid){
		$http({
			method : "GET",
			url : "http://localhost:8485/middleware.project2/addBlogDisLike?BlogId="+blogid+""
		}).then(function mySuccess(response){
			$scope.responsealluserdislike = response.data;
			$scope.allotheruserblogbtn();
		},
		function myError(response){
			$scope.responsealluserdislike = response.statusText;
		});
	}	
});

var data = new FormData();

app.directive('fileModel', ['$parse', function ($parse) {
    return {
        restrict: 'A',
        link: function(scope, element, attrs) {
           var model = $parse(attrs.fileModel);
           var modelSetter = model.assign;
           
           element.bind('change', function(){
              scope.$apply(function(){
              modelSetter(scope, element[0].files[0]);
              data.append("file",element[0].files[0]);
           });
           });
         }
      };
 }]);

app.controller("myprofilectrl",function($scope,$rootScope,$http){
    $scope.showallusermultimedia = function(){
	$http({
		method : "GET",
		url : "http://localhost:8485/middleware.project2/usermultimediaByUserEmail?useremail="+$rootScope.rootuser.userEmail+""
	}).then(function mySuccess(response){
		$scope.responseusermultimediabyuseremail = response.data;
		},
	     function myError(response){
		$scope.responseusermultimediabyuseremail = response.statusText;
	     });	
	}
	$scope.showallusermultimedia();
	$scope.addusermultimediabtn = function(){
		var file = $scope.uploadedFile;
		var url = "http://localhost:8485/middleware.project2/addUserMultimedia?file&useremail="+$rootScope.rootuser.userEmail;
	    data;
	    var config = {
	    		transformRequest: angular.identity,
	    	   	transformResponse: angular.identity,
		   		headers : {
		   			'Content-Type': undefined
		}
	    }
	       
	    $http.post(url, data, config).then(function mySuccess(response) {
				$scope.uploadResult=response.data;
				alert("multimedia added please logout and refresh to view added multimedia");
				$scope.showallusermultimedia();
		}, function myError(response) {
				$scope.uploadResult=response.statusText;
		});
	    };
	    
	    $scope.deleteusermultimediabtn = function(usermultimediaid){
	    	$http({
	    		method : "GET",
	    		url : "http://localhost:8485/middleware.project2/deleteUserMultimedia?usermultimediaid="+usermultimediaid
	    	}).then(function mySuccess(response){
	    		$scope.deleteusermultimedia = response.data;
	    		alert("multimedia deleted");
	    		$scope.showallusermultimedia();
	    	},
	    	function myError(response){
	    		$scope.deleteusermultimedia = response.statusText;
	    	});
	    };
	    
	    $scope.likeusermultimediabtn = function(usermultimediaid){
	    	 $http({
	    		method : "GET",
	    		url : "http://localhost:8485/middleware.project2/addUserMultimediaLike?usermultimediaid="+usermultimediaid
	    	 }).then(function mySuccess(response){
	    		$scope.likeusermultimedia = response.data; 
	    		$scope.showallusermultimedia();
	    	 },
	    	 function myError(response){
	    		 $scope.likeusermultimedia = response.statusText;
	    	 });
	    };
	    
	    $scope.dislikeusermultimediabtn = function(usermultimediaid){
	    	$http({
	    		method : "GET",
	    		url : "http://localhost:8485/middleware.project2/addUserMultimediaDislike?usermultimediaid="+usermultimediaid
	    	}).then(function mySuccess(response){
	    	    $scope.dislikeusermultimedia = response.data;
	    	    $scope.showallusermultimedia();
	    	},
	    	function myError(response){
	    		$scope.dislikeusermultimedia = response.statusText;
	    	});
	    };
});

app.controller("allusermultimediactrl",function($scope,$rootScope,$http){
	
	     $scope.allusermultimedia = function(){
		     $http({
		    	method : "GET",
		        url : "http://localhost:8485/middleware.project2/otherUserMultimediaByUserEmail?useremail="+$rootScope.rootuser.userEmail	
		     }).then(function mySuccess(response){
		    	 $rootScope.otherallusermultimedia = response.data;
		    	 },
		     function myError(response){
		    	 $rootScope.otherallusermultimedia = response.statusText;
		     });
	      }
	      $scope.allusermultimedia();
	      
	      $scope.likeallusermultimediabtn = function(usermultimediaid){
	    	  $http({
	    		method : "GET",
	    		url : "http://localhost:8485/middleware.project2/addUserMultimediaLike?usermultimediaid="+usermultimediaid
	    	  }).then(function mySuccess(response){
	    		 $scope.addusermultimedialike = response.data;
	    		 $scope.allusermultimedia();
	    	  },
	    	  function myError(response){
	    		  $scope.addusermultimedialike = response.statusText;
	    	  });
	      }; 
	      
	      $scope.dislikeallusermultimediabtn = function(usermultimediaid){
	    	  $http({
	    	    method : "GET",
	    	    url : "http://localhost:8485/middleware.project2/addUserMultimediaDislike?usermultimediaid="+usermultimediaid
	    	  }).then(function mySuccess(response){
	    		  $scope.addusermultimediadislike = response.data;
	    		  $scope.allusermultimedia();
	    	  },
	    	  function myError(response){
	    		  $scope.addusermultimediadislike = response.statusText;
	    	  });
	      };
});

app.controller("addfriendsctrl",function($scope,$rootScope,$http){
	     $scope.userwithoutimage = function(){
	    	 $http({
	  	       method : "GET",
	  	       url : "http://localhost:8485/middleware.project2/userByEmail?useremail="+$rootScope.rootuser.userEmail
	       }).then(function mySuccess(response){
	  	   $rootScope.userwoutimage = response.data;
	  	   console.log($rootScope.userwoutimage);
	  	  },
	       function myError(response){
	  		$rootScope.userwoutimage = response.statusText;
	           }); 
	     }
	     $scope.userwithoutimage();
	     
	     $scope.allusers = function(){
 	          $http({
 		       method : "GET",
 		       url : "http://localhost:8485/middleware.project2/allOtherUser?useremail="+$rootScope.rootuser.userEmail
 	      }).then(function mySuccess(response){
 		   $scope.allotheruserbyemail = response.data;
 		   console.log($scope.allotheruserbyemail);
 		  },
 	      function myError(response){
 		       $scope.allotheruserbyemail = response.statusText;
 	          });
           }
	       $scope.allusers();
	      
	       $scope.sendrequestbtn = function(friendemailid,idd,file,file1){
	    	   $http({
	    		method : "GET",
	    		url : "http://localhost:8485/middleware.project2/addFriend?friendemailid="+friendemailid+"&useremail="+$rootScope.rootuser.userEmail+"&friendimage="+file+"&userfriendimage="+file1
	    	   }).then(function mySuccess(response){
	    		   $scope.sendrequest = response.data;
	    		   document.getElementById(idd).style="display:none";
	    		   alert("request sent");
	    		},
	    	   function myError(response){
	    			$scope.sendrequest = response.statusText;
	    		});
	    	}
	       
	       $scope.sendrequest2btn = function (friendemailid,idd,file,file1){
	    	   $http({
	    		method : "GET",
	    		url : "http://localhost:8485/middleware.project2/addFriend?friendemailid="+friendemailid+"&useremail="+$rootScope.rootuser.userEmail+"&friendimage="+file+"&userfriendimage="+file1
	    	   }).then(function mySuccess(response){
                   $scope.sendrequest2 = response.data;
                   document.getElementById(idd).style="display:none";
                   alert("request sent");
	    	   },
	    	   function myError(response){
	    		   $scope.sendrequest2 = response.statusText;
	    	   });
	    	 }
	       
	       $scope.sendrequest3btn = function (friendemailid,idd,file,file1){
	    	   $http({
	    		method : "GET",
	    		url : "http://localhost:8485/middleware.project2/addFriend?friendemailid="+friendemailid+"&useremail="+$rootScope.rootuser.userEmail+"&friendimage="+file+"&userfriendimage="+file1
	    	   }).then(function mySuccess(response){
                   $scope.sendrequest2 = response.data;
                   document.getElementById(idd).style="display:none";
                   alert("request sent");
	    	   },
	    	   function myError(response){
	    		   $scope.sendrequest2 = response.statusText;
	    	   });
	    	 }
	       
	       $scope.sendrequest4btn = function (friendemailid,idd,file,file1){
	    	   $http({
	    		method : "GET",
	    		url : "http://localhost:8485/middleware.project2/addFriend?friendemailid="+friendemailid+"&useremail="+$rootScope.rootuser.userEmail+"&friendimage="+file+"&userfriendimage="+file1
	    	   }).then(function mySuccess(response){
                   $scope.sendrequest2 = response.data;
                   document.getElementById(idd).style="display:none";
                   alert("request sent");
	    	   },
	    	   function myError(response){
	    		   $scope.sendrequest2 = response.statusText;
	    	   });
	    	 }
});

app.controller("friendsctrl",function($scope,$rootScope,$http){
	
	 $scope.recievenonconfirmrequest = function(){
		    $http({
	    		method : "GET",
	    		url : "http://localhost:8485/middleware.project2/recievenonconfirmfriendrequest?useremail="+$rootScope.rootuser.userEmail+"&friendtype=non confirm"
	    	}).then(function mySuccess(response){
              $rootScope.noncrequest = response.data;
            },
	    	function myError(response){
            	alert("false");
	    	  $rootScope.noncrequest = response.statusText;
	    	});
	    }
	 $scope.recievenonconfirmrequest();
	 
	 $scope.confrimfriendtype = function(){
			$http({
			method : "GET",
			url : "http://localhost:8485/middleware.project2/friendConfirmList?friendtype=confirm"
			}).then(function mySuccess(response){
				$rootScope.cfriendtype = response.data;
			},
			function myError(response){
				$rootScope.cfriendtype = response.statusText;
			});
		}
    $scope.confrimfriendtype();
	    
	$scope.confirmfrndbtn = function(id){
		$http({
			  method : "GET",
			  url : "http://localhost:8485/middleware.project2/convertNonconfirmToConfirm?friendid="+id+"&friendtype=confirm"
		  }).then(function mySuccess(response){
			 $scope.confirmfriend = response.data;
			 $scope.recievenonconfirmrequest();
			 $scope.confrimfriendtype();
		  },
		  function myError(response){
			 $scope.confirmfriend = response.statusText; 
		  });
	}
	
	$scope.deletefrndbtn = function(id){
		$http({
			method : "GET",
			url : "http://localhost:8485/middleware.project2/deleteFriend?friendid="+id
		}).then(function mySuccess(response){
			$scope.deletefriendrequest = response.data;
			$scope.recievenonconfirmrequest();
			$scope.confrimfriendtype();
		},
		function myError(response){
			$scope.deletefriendrequest = response.statusText;
		});
	}
	
	$scope.removebtn = function(id){
		$http({
			method : "GET",
			url : "http://localhost:8485/middleware.project2/deleteFriend?friendid="+id
		}).then(function mySuccess(response){
			$scope.remove = response.data;
			$scope.recievenonconfirmrequest();
			$scope.confrimfriendtype();
		},
		function myError(response){
			$scope.remove = response.statusText;
		});
	}
	
	$scope.chatbtn = function(cfrnd){
		$http({
			method : "GET",
			url : "http://localhost:8485/middleware.project2/userByStatus?userstatus=yes&useremail="+cfrnd
		}).then(function mySuccess(response){
	      $rootScope.chatfriend = response.data;
	      console.log($rootScope.chatfriend);
	    },
		function myError(response){
		  $rootScope.chatfriend = response.statusText;
		});
	}
	$scope.chatbtn1 = function(cfrind){
		$http({
			method : "GET",
			url : "http://localhost:8485/middleware.project2/userByStatus?userstatus=yes&useremail="+cfrind
		}).then(function mySuccess(response){
	      $rootScope.chatuserfriend = response.data;
	      console.log($rootScope.chatuserfriend);
	    },
		function myError(response){
		  $rootScope.chatuserfriend = response.statusText;
		});
	}
});

app.controller("chatctrl",function($scope,$rootScope,$http){
	$scope.allchat = function(){
		$http({
			method : "GET",
			url : "http://localhost:8485/middleware.project2/allChat"
		}).then(function mySuccess(response){
		  $rootScope.all_c = response.data;
		  console.log($rootScope.all_c);
		},
		function myError(response){
			$rootScope.all_c = response.statusText();	
		});
	}
	$scope.allchat();
	
	$scope.addchatbtn = function(email,chatmessage1234){
	$http({
		method : "GET",
		url : "http://localhost:8485/middleware.project2/addChat?chatmessage="+chatmessage1234+"&chatto="+email+"&chatfrom="+$rootScope.rootuser.userEmail
	}).then(function mySuccess(response){
		$scope.save_chat = response.data;
		$scope.allchat();
	},
	function myError(response){
		$scope.save_chat = response.statusText;
	});
	}
		
    $scope.addchatbtn1 = function(email,chatmessage1){
	$http({
	   method : "GET",
	   url : "http://localhost:8485/middleware.project2/addChat?chatmessage="+chatmessage1+"&chatto="+email+"&chatfrom="+$rootScope.rootuser.userEmail
	}).then(function mySuccess(response){
		$scope.save_chat1 = response.data;
		$scope.allchat();
	},
	function myError(response){
		$scope.save_chat1 = response.statusText;
	});
	}
});