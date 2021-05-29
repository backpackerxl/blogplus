$('.menu-toggle').click(function () {
    $('.m-item').toggleClass('m-mobile-hide');

});

$('#payButton').popup({
    popup: $('.payQR.popup'),
    on: 'click',
    position: 'bottom center'
});

$('.qq').popup();

$('.weixin').popup({
    popup: $('.weichartQR.popup'),
    on: 'hover',
    position: 'bottom center'
});

$('.ui.dropdown').dropdown({
    on: 'hover'
});

$('.ui.form').form({
    fields: {
        title: {
            identifier: 'title',
            rules: [{
                type: 'empty',
                prompt: '标题：请输入博客标题'
            }]
        }
    }
});

$('.toc-btn').popup({
    popup: $('.toc-container.popup'),
    on: 'click',
    position: 'left center'
});

tocbot.init({
    // Where to render the table of contents.
    tocSelector: '.js-toc',
    // Where to grab the headings to build the table of contents.
    contentSelector: '.js-toc-content',
    // Which headings to grab inside of the contentSelector element.
    headingSelector: 'h1, h2, h3',
    // For headings inside relative or absolute positioned containers within content.
    hasInnerContainers: true,
});

$('.weixin').popup({
    popup: $('.weichartqr.popup'),
    on: 'hover',
    position: 'left center'
});
$('#toTop').click(function () {
    $(window).scrollTo(0, 1000);
});

var waypoint = new Waypoint({
    element: document.getElementById('waypoint'),
    handler: function (direction) {
        if (direction == 'down') {
            $('#toolbar').show(500);
        } else {
            $('#toolbar').hide(500);
        }
        console.log('Scrolled to waypoint!' + direction);
    }
})