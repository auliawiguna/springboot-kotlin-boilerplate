var gulp = require('gulp');
var gulpMinifyCss = require('gulp-minify-css');
var gulpConcat = require('gulp-concat');
var gulpUglify = require('gulp-uglify');
var gulpHtmlmin = require('gulp-htmlmin');

gulp.task('hello', async function(){
    console.log("Hello world!");
});


// task untuk minify
gulp.task('css', async function () {
    gulp.src([
        './backend/css/lib/bootstrap/bootstrap.min.css',
        './backend/css/lib/calendar2/semantic.ui.min.css',
        './backend/css/lib/calendar2/pignose.calendar.min.css',
        './backend/css/lib/owl.carousel.min.css',
        './backend/css/lib/owl.theme.default.min.css',
        './backend/css/helper.css',
        './backend/css/style.css',
        //Datatable
        './backend/vendor/datatable/css/datatables.min.css',
        //izitoast
        './backend/vendor/izitoast/css/iziToast.min.css',
        //select2
        './backend/vendor/select2/css/select2.min.css',
        //validation engine
        './backend/vendor/validation-engine/css/validationEngine.jquery.css'
    ])
    .pipe(gulpMinifyCss({
        compatibility: 'ie11'
    }))
    .pipe(gulpConcat('app.css'))
    .pipe(gulp.dest('./dist/backend/css'));

    //copy fonts
    gulp.src('./backend/icons/font-awesome/fonts/*')
    .pipe(gulp.dest('./dist/backend/icons/font-awesome/fonts'));

    gulp.src('./backend/icons/font-awesome/fonts/*')
    .pipe(gulp.dest('./dist/backend/fonts'));

    gulp.src('./backend/icons/themify-icons/fonts/*')
    .pipe(gulp.dest('./dist/backend/icons/themify-icons/fonts'));
});

gulp.task('js', async function () {
    gulp
        .src([
            './backend/js/lib/jquery/jquery.min.js',
            './backend/js/lib/bootstrap/js/popper.min.js',
            './backend/js/lib/bootstrap/js/bootstrap.min.js',
            './backend/js/jquery.slimscroll.js',
            './backend/js/sidebarmenu.js',
            './backend/js/lib/sticky-kit-master/dist/sticky-kit.min.js',
            './backend/js/lib/morris-chart/raphael-min.js',
            './backend/js/lib/morris-chart/morris.js',
            './backend/js/lib/morris-chart/dashboard1-init.js',
            './backend/js/lib/calendar-2/moment.latest.min.js',
            './backend/js/lib/calendar-2/semantic.ui.min.js',
            './backend/js/lib/calendar-2/prism.min.js',
            './backend/js/lib/calendar-2/pignose.calendar.min.js',
            './backend/js/lib/calendar-2/pignose.init.js',
            './backend/js/lib/owl-carousel/owl.carousel.min.js',
            './backend/js/lib/owl-carousel/owl.carousel-init.js',
            //Bootbox
            './backend/vendor/bootbox/js/bootbox.all.min.js',
            //Datatable
            './backend/vendor/datatable/js/datatables.min.js',
            //izitoast
            './backend/vendor/izitoast/js/iziToast.min.js',
            //select2
            './backend/vendor/select2/js/select2.full.min.js',
            //validation engine
            './backend/vendor/validation-engine/js/jquery.validationEngine.js',
            './backend/vendor/validation-engine/js/jquery.validationEngine-en.js',
            './backend/js/helper.js',
            './backend/js/scripts.js',
            './backend/js/custom.min.js',
            './backend/content/*.js',
        ])
        .pipe(gulpConcat('app.js'))
        .pipe(gulpUglify())
        .pipe(gulp.dest('./dist/backend/js'));
});
