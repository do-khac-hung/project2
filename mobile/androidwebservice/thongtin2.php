<?php

/**
 * Created by PhpStorm.
 * User: Anonymus
 * Date: 26/11/2017
 * Time: 3:21 CH
 */

if (isset($_POST['user'])){
    require_once "Databse.php";
    $info = new Databse();

    $user = $_POST['user'];

    foreach ($info->getRow("SELECT NguoiDungID FROM nguoidung WHERE TenNguoiDung='$user'") as $value){
              $DocGiaID = $value;
    }
    $data = array();
    $thongtin = array();
    $data = $info -> getAllList("SELECT TenSach,TacGia,pmchitiet.NgayQuaHan,pmchitiet.TrangThai FROM sach,pmchitiet,phieumuon WHERE phieumuon.DocGiaID = '$DocGiaID'
AND pmchitiet.PhieuMuonID = phieumuon.PhieuMuonID AND sach.SachID = pmchitiet.SachID");
    foreach ($data as $value){
        foreach ($value as $v){
            $thongtin [] = $v;
        }
    }
    $sachquahan = array();
    $soluong = count($thongtin)/4;
    for ($i = 0;$i<$soluong;$i++){
        if ($thongtin[4*$i+3] == 2){
            $sachquahan[] = $i;
        }
    }


    class thongtin{

        function thongtin($ngayquahan,$tensach,$tacgia,$tinhtrang){
            $this->NgayQuaHan=$ngayquahan;
            $this->TenSach=$tensach;
            $this->TacGia=$tacgia;
            $this->TrangThai=$tinhtrang;
        }
    }
    $mang=array();
    for ($i = 0;$i<$soluong;$i++){
        $tinhtrang = "";
        if ($thongtin[4*$i+3] == 0){
            $tinhtrang = "Đã mượn";
        }else if ($thongtin[4*$i+3] == 2) {
            $tinhtrang = "Quá hạn";
        }else if ($thongtin[4*$i+3] == 1){
            $tinhtrang = "Đã trả";
        }

        array_push($mang,new thongtin($thongtin[4*$i+2],$thongtin[4*$i+0],$thongtin[4*$i+1],$tinhtrang));
    }

    echo json_encode($mang);
}

 ?>
           