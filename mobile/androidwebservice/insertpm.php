<?php
$connect=mysqli_connect("localhost","root","","quanlythuvien");
mysqli_query($connect,"SET NAMES 'utf8'");

$SachID=$_POST['SachID'];
$NgayHenTra=$_POST['NgayHenTra'];
$NgayMuon=$_POST['NgayMuon'];
$NgayTra=$_POST['NgayTra'];
$TienCoc=$_POST['TienCoc'];
$DocGiaID=$_POST['DocGiaID'];
$SoLuongMuon=$_POST['SoLuongMuon'];
//$query1="SELECT MAX(PhieuMuonID) FROM pmchitiet";
//$result1=mysqli_query($connect,$query1);
//$row = mysqli_fetch_array ($result1);
//$a= $row['PhieuMuonID'];
//echo $a;
$query="INSERT INTO `quanlythuvien`.`pmchitiet` (`PhieuMuonID`, `SachID`, `NgayTra`, `TienCoc`) VALUES ('22', '$SachID', '$NgayTra', '40000')";
$result=mysqli_query($connect,$query);
if($result){
	echo "success";
}
else
{
	echo "lỗi";
}



?>