<?php
$connect=mysqli_connect("localhost","root","","quanlythuvien");
mysqli_query($connect,"SET NAMES 'utf8'");

$SachID=$_POST['SachID'];
$LoaiSachID=$_POST['LoaiSachID'];
$NgonNguID=$_POST['NgonNguID'];
$NhaXB=$_POST['NhaXB'];
$TenSach=$_POST['TenSach'];
$TacGia=$_POST['TacGia'];
$NgayNhap=$_POST['NgayNhap'];
$GiaTien=$_POST['GiaTien'];
$SoLuong=$_POST['SoLuong'];
$SoLuongCon=$_POST['SoLuongCon'];

//$query1="SELECT MAX(PhieuMuonID) FROM pmchitiet";
//$result1=mysqli_query($connect,$query1);
//$row = mysqli_fetch_array ($result1);
//$a= $row['PhieuMuonID'];
//echo $a;
$query1="INSERT INTO `quanlythuvien`.`ngonngu` (`ngonnguID`, `Tenngonngu`) VALUES ('5', 'Tiếng Lào');";
$result1=mysqli_query($connect,$query1);
$query2="INSERT INTO `quanlythuvien`.`loaisach` (`LoaiSachID`, `TenLoaiSach`) VALUES ('4', 'chuyện ngụ ngôn ');";
$result2=mysqli_query($connect,$query2);
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