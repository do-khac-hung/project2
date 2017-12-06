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
$query="update sach set NhaXB='$NhaXB',TenSach='$TenSach',
TacGia='$TacGia',NgayNhap='$NgayNhap',GiaTien='$GiaTien',
SoLuong='$SoLuong',SoLuongCon='$SoLuongCon'
where SachID='$SachID'";
$result=mysqli_query($connect,$query);
if($result){
	echo "success";
}else
{
	echo "lỗi";
}
?>