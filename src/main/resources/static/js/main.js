//$(function(){
//
//searchWord = function(){
//    var searchResult,
//        searchText = $('.form-control').val(),//検索ボックスに入力された値
//        targetText,
//        hitNum;
//
//        //検索結果を格納する為の配列を用意する
//        searchResult = [];
//
//        $('.target-area').empty();
//        $('.panel-title').empty();
//
//
//        //検索ボックスに値が入っていたら
//        if(searchText != null){
//            $('td').each(function(){
//                targetText = $('.form-control').val();
//
//                console.log(targetText);
//
//                //検索対象となるリストに入力された文字列が存在するかどうかを判断
//                if(targetText.indexOf(searchText) != -1){
//                    //存在する場合はそのリストのテキストを用意した配列に格納
//                    searchResult.push(targetText);
//                }
//            });
//
//          //検索結果をページに出力する
//          for(var i = 0; i < searchResult.length; i++){
//            $('<span>').text(searchResult[i]).appendTo(".result");
//          }
//
//          //ヒット件数をページに出力する
//          hitNum = '<span>検索結果<span>' + searchResult.length + '件見つかりました'
//            $('.panel-title').append(hitNum);
//        }
//    };
//
//    $('.form-control').on('input', searchWord);
//
//});