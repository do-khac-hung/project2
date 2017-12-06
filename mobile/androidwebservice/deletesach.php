<?php
$connect=mysqli_connect("localhost","root","","quanlythuvien");
mysqli_query($connect,"SET NAMES 'utf8'");
$SachID=$_POST['SachID'];
$query="delete from sach where where SachID='$SachID'";
$result=mysqli_query($connect,$query);
if($result){
	echo "success";
}else
{
	echo "lỗi";
}
?>