<?php
//session_start();
//$name = $_SESSION['user'];


include "Databse.php";

if (isset($_POST["user"])&&isset($_POST["pass"]) && isset($_POST["masach"]) &&isset($_POST["date"])){
    $user = $_POST["user"];
    $pass = $_POST["pass"];
    $text= $_POST["masach"];
    $date =$_POST["date"];
    $db = new Databse();

    $tiencoc = array();
    $temp = array();
    $masach = array();
    $masach = explode(',',$text);


    $now = getdate();
    $currentDate = $now["year"] . "-" . $now["mon"] . "-" . $now["mday"];

    //Lấy độc giả ID

    foreach ( $db->getRow("SELECT NguoiDungID FROM nguoidung WHERE TenNguoiDung= '$user'") as $value){
        $docgiaID = $value;
    }
    foreach ($masach as $value){
        $temp = $db->getRow("SELECT GiaTien FROM sach WHERE SachID = '$value'");
        if (is_array($temp) || is_object($temp))
        {
            foreach ($temp as $v)
            {
                $tiencoc [] = $v;
            }
        }
    }
    //số lượng mượn tối da là 6 quyển
    $soluong='';
    foreach ($db->getAllList("SELECT SoLuongMuon FROM phieumuon 
	WHERE DocGiaID ='$docgiaID'" ) as $value){
        foreach ($value as $s){
            $soluong = $soluong + $s;
        }
    }
    $soluong = $soluong + count($masach);

    //nếu bị quá hạn thì không thể mượn được nữa và bị phạt
    $quahan = 0;
    foreach ($db->getAllList("SELECT pmchitiet.TrangThai FROM pmchitiet,phieumuon WHERE phieumuon.DocGiaID = '$docgiaID'
AND pmchitiet.PhieuMuonID = phieumuon.PhieuMuonID") as $value){
        foreach ($value as $v){
            if ($v == 2){
                $quahan ++;
            }
        }
    }

    $tc = "";
    foreach ($tiencoc as $value){
        $tc = $tc + $value;
    }

    $data = array();
    $data['DocGiaID'] = $docgiaID;
    $data['CacMaSachMuon'] = $text;
    $data['NgayMuon'] = $date;
    $data['NgayDangKyMuon'] = $currentDate;
    $data['SoLuongMuon'] = count($masach);
    $data['TienCoc'] =  floor($tc/3);
    $data['TrangThai'] = 0;

    //var_dump($data);

    if ($soluong <=6 && $quahan==0){
        $return =$db->InsertDatabase('phieumuon',$data);
        if ($return){
            echo "success";
        }
    }else{
        echo "Số lượng sách mượn đã quá 6 cuốn hoặc bạn đã quá hạn một số sách";
    }




}
?>