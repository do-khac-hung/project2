<?php
$connect=mysqli_connect("localhost","root","","quanlythuvien");
mysqli_query($connect,"SET NAMES 'utf8'");
$query="select* from nguoidung";
$data=mysqli_query($connect,$query);
class user{ 

		var $NguoiDungID;
		var $TenNguoiDung;
		var $MatKhau;
		var $VaiTro;
		var $HoVaTen;
		var $DiaChi;
		var $Email;
		var $DienThoai;
		var $ChungMinhThu;
		
		
		function user($NguoiDungID,$TenNguoiDung,$MatKhau,$VaiTro,$HoVaTen,$DiaChi,$Email,$DienThoai,$ChungMinhThu){
			$this->NguoiDungID=$NguoiDungID;
			$this->TenNguoiDung=$TenNguoiDung;
			$this->MatKhau=$MatKhau;
			$this->VaiTro=$VaiTro;
			$this->HoVaTen=$HoVaTen;
			$this->DiaChi=$DiaChi;
			$this->Email=$Email;
			$this->DienThoai=$DienThoai;
			$this->ChungMinhThu=$ChungMinhThu;
			
			
			}
}
$mang=array();
while($row=mysqli_fetch_assoc($data)){
	array_push($mang,new user($row['NguoiDungID'],$row['TenNguoiDung'],$row['MatKhau'],$row['VaiTro']
	,$row['HoVaTen'],$row['DiaChi'],$row['Email'],$row['DienThoai'],$row['ChungMinhThu']));
	}
	echo json_encode($mang);
?>
