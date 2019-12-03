$(function() {
	var cname = $('#custName');
	var cpwd = $('#custpwd');
	var cpwd1 = $('#custpwd1');
	var cmoblie = $('#mobile');
	var cptCode = $('#PT_CONFIRM_PWD');
	var cmoblieCode = $('#mobileVeryCode');
	var error_tip = $('.error_tip');
	var qiangdu = $('.qiangdu td');
	//学号验证
	$('.p1').show();
	$('.p1').html('请输入11位数字');
	cname.focus(function() {
		$('.p1').show();
		$('.e1').hide();
		$('.p1').html('请输入11位数字');
	}).blur(function() {
		var regName = /^\d{11}$/;
		$('.p1').hide();
		$('.e1').show();
		if (cname.val().length != 0) {
			if (!regName.test(cname.val())) {
				error_tip.html('学号请输入11位数字')
			} else {
				$('.c1').show();
				error_tip.hide()
			}
		} else {
			$('.e1').html('学号不能为空')
		}
	})

	// 登录密码验证
	cpwd.focus(function() {

		$('.p2').show();
		$('.e2').hide();
		$('.p2').html('6-16个字符，由英文字母（区分大小写）、数字、符号组成，请勿使用');

	}).blur(function() {
		var regPwd1 = /^\d{6,16}$/;
		$('.p2').hide()
		$('.e2').show();
		if (cpwd.val().length >= 6) {
			$('.e2').hide();
			$('.c2').show();
			$('.c2').html('')
			// if(!regPwd1.test(cpwd.val())){
			// 	
			// }
		} else {
			$('.e2').html('密码最少为6位')
			cpwd.val('');
		}

	})


	//确认密码验证
	cpwd1.blur(function() {
		$('.e3').show();
		if (cpwd1.val().length != 0) {
			if (cpwd1.val() == cpwd.val()) {
				$('.e3').hide();
				$('.c3').show();
			} else {

				$('.e3').html('两次密码输入不一致');
			}
		} else {
			$('.e3').html('密码最少为6位');
		}
	})



	// 验证码验证
	var code_tip = $('#error_img');
	var code_value = $('#code');
	cptCode.focus(function() {

	}).blur(function() {
		if (cptCode.val().toUpperCase()!= code_value.val()) {
			$('.e5').show()
			$('.e5').html('请输入正确的附加码')
			code_tip.attr('src','img/derr.gif')
			code_tip.show()
		} else {
			$('.e5').hide()
			code_tip.attr('src','img/a3.gif')
			code_tip.show()
		}

	})

	


	
})
