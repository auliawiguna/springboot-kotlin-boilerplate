$(function () {
    var page = $('#profile-page');
    var app = {
        init : function () {
            if ($('#flashMessage').val() != '' && ($('#flashMessage').val() != null || $('#flashMessage').val() != 'null')) {
                helper.setAlert($('#flashMessage').val(), 'success');
            }            
        }
    }

    if (page.length) {
        app.init();
    }
});