
$(document).ready(function(){
    $("#champion").click(function(){
        $("#championName").removeClass('hidden').addClass('label');
    });
    $("#first").click(function(){
        $("#firstName").removeClass('hidden').addClass('label');
    });
    $("#second").click(function(){
        $("#secondName").removeClass('hidden').addClass('label');
    });
    $("#popular").click(function(){
        $("#popularName").removeClass('hidden').addClass('label');
    });
});