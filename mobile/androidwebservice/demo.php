<?php
$connect=mysqli_connect("localhost","root","","sinhvien");
mysqli_query($connect,"SET NAMES 'utf8'");
$query="select* from sinhvien";
$data=mysqli_query($connect,$query);
class sinhvien{ 

		function sinhvien($id,$hoten,$namsinh,$diachi){
			$this->ID=$id;
			$this->HoTen=$hoten;
			$this->NamSinh=$namsinh;
			$this->DiaChi=$diachi;
			
		
			
			}
}
$mang=array();
while($row=mysqli_fetch_assoc($data)){
	array_push($mang,new sinhvien($row['id'],$row['hoten'],$row['namsinh'],$row['diachi']));
	}
	echo json_encode($mang);
?>
