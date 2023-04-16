window.onload = function(){
	
	$(document).ready(function() {
    var itemCount = $("tr.jinho").length;
    var totalPrice = 0;
    $("input.individual_totalPrice_input").each(function() {
      totalPrice += parseInt($(this).val());
    });
    $(".quantity").text(itemCount);
    $(".totalPrice1").text(totalPrice.toLocaleString());
    $(".payAmountSum").text(totalPrice.toLocaleString());
    $("input[name=payAmountSumPrice]").val(totalPrice);
  });
  
  var totalCount = 0;
  
  $(".jinho").each(function(index, element){
	  
	  var sbAmount = parseInt($(element).find(".individual_sbAmount_input").val());
	  totalCount += sbAmount;
	  });
	  
	  $(".totalCount").val(totalCount);
  
  var item = [];
$("tr.jinho").each(function() {
  const sbNo = $(this).find("input[name=sbNo]").val();
  const pcAmount = $(this).find("input[name=sbCount]").val();
  item.push({
    sbNo : sbNo,
    sbCount : pcAmount
  });
});
console.log(item);
$("input[name=item]").val(item);
console.log($("input[name=item]").val(JSON.stringify(item)));
}