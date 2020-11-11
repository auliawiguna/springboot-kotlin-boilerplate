var helper = {};
$(document).ready(function () {
	helper = {
		init: function () {
			this.initElement();
		},
		initElement: function () {
			$(document).tooltip({
	            selector: '[data-toggle="tooltip"]'
	        });            
            if ($(".notif-alert").length) {
                var alertMessage = $(".notif-alert").val();
                var alertType = $(".notif-alert").data('type');
                helper.setAlert(alertMessage, alertType);
            }
			/* Init CKEditor */
			if ($(".form-ckeditor").length) {
				var config = {
					'toolbarGroups': [
						{ name: 'document', groups: [ 'Source', '-', 'mode', 'document', 'doctools' ] },
						{ name: 'clipboard', groups: [ 'clipboard', 'undo' ] },
						{ name: 'editing', groups: [ 'find', 'selection', 'spellchecker', 'editing' ] },
						{ name: 'forms', groups: [ 'forms' ] },
						{ name: 'basicstyles', groups: [ 'basicstyles', 'cleanup' ] },
						{ name: 'paragraph', groups: [ 'list', 'indent', 'blocks', 'align', 'bidi', 'paragraph' ] },
						{ name: 'links', groups: [ 'links' ] },
						{ name: 'styles', groups: [ 'styles' ] },
						{ name: 'insert', groups: [ 'insert' ] },
						'/',
						'/',
						{ name: 'colors', groups: [ 'colors' ] },
						{ name: 'tools', groups: [ 'tools' ] },
						{ name: 'others', groups: [ 'others' ] },
						{ name: 'about', groups: [ 'about' ] }
					],
					'removeButtons': 'Form,Checkbox,Radio,TextField,Textarea,Select,Button,ImageButton,HiddenField,Scayt,SelectAll,Replace,Maximize,ShowBlocks,About,Flash,HorizontalRule,Format,Font,TextColor,BGColor,Save,NewPage,Preview,Print,Smiley,SpecialChar,PageBreak,Iframe,CopyFormatting,RemoveFormat,Subscript,Superscript,BidiLtr,BidiRtl,Language,Templates,Styles'
				};
				$(".form-ckeditor").each(function(index) {
					CKEDITOR.replace($(this).attr('id'), config);
				});
			}
			/* Init Select2 */
			if ($(".form-select2").length) {
				$(".form-select2").select2();
            }            
		},
		deleteConfirm: function(message, functionCallback, rowId) {
	        bootbox.confirm({
	            message: message,
	            buttons: {
	                confirm: {
	                    label: 'Delete',
	                    className: 'btn-danger'
	                },
	                cancel: {
	                    label: 'Cancel',
	                    className: 'btn-default'
	                }
	            },
	            callback: function(result) {
	                if (result) {
	                    functionCallback(rowId);
	                }
	            }
	        });
	    },
		okConfirm: function(message, functionCallback, rowId) {
	        bootbox.confirm({
	            message: message,
	            buttons: {
	                confirm: {
	                    label: 'OK',
	                    className: 'btn-success'
	                },
	                cancel: {
	                    label: 'Cancel',
	                    className: 'btn-default'
	                }
	            },
	            callback: function(result) {
	                if (result) {
	                    functionCallback(rowId);
	                }
	            }
	        });
	    },
	    setAlert: function (message, type) {		
            iziToast.settings({
                position: 'topRight',
                transitionIn: 'fadeInDown',
                transitionOut: 'flipOutX',
                balloon: true,
                timeout: 4000
            });
            switch (type) {
                case 'success':
                    iziToast.success({
                        title: 'OK',
                        message: message,
                    });
                    break;
                case 'warning':
                    iziToast.warning({
                        title: 'Warning',
                        message: message,
                    });
                    break;
                case 'danger':
                    iziToast.error({
                        title: 'Error',
                        message: message,
                    });
                    break;
                case 'info':
                    iziToast.info({
                        title: 'Info',
                        message: message,
                    });
                    break;
                default:
                    iziToast.show({
                        message: message,
                    });
                    break;
            }
	    },
		listenTabs: function () {
			// Javascript to enable link to tab
			var url = document.location.toString();
			if (url.match('#')) {
				$('.nav-tabs a[href="#' + url.split('#')[1] + '"]').tab('show');
			}

			// Change hash for page-reload
			$('.nav-tabs a').on('shown.bs.tab', function (e) {
				window.location.hash = e.target.hash;
			});
		}
	};
	helper.init();
});