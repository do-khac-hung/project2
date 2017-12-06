<?php
$connect=mysqli_connect("localhost","root","","quanlythuvien");
mysqli_query($connect,"SET NAMES 'utf8'");
$query="select* from sach";
$data=mysqli_query($connect,$query);
class sach{ 

		var $SachID;
		var $LoaiSachID;
		var $NgonNguID;
		var $NhaXB;
		var $TenSach;
		var $TacGia;
		var $NgayNhap;
		var $GiaTien;
		var $SoLuong;
		var $SoLuongCon;
		
		function sach($SachID,$LoaiSachID,$NgonNguID,$NhaXB,$TenSach,$TacGia,$NgayNhap,$GiaTien,$SoLuong,$SoLuongCon){
			$this->SachID=$SachID;
			$this->LoaiSachID=$LoaiSachID;
			$this->NgonNguID=$NgonNguID;
			$this->NhaXB=$NhaXB;
			$this->TenSach=$TenSach;
			$this->TacGia=$TacGia;
			$this->NgayNhap=$NgayNhap;
			$this->GiaTien=$GiaTien;
			$this->SoLuong=$SoLuong;
			$this->SoLuongCon=$SoLuongCon;
			
			}
}
$mang=array();
while($row=mysqli_fetch_assoc($data)){
	array_push($mang,new sach($row['SachID'],$row['LoaiSachID'],$row['NgonNguID'],$row['NhaXB'],$row['TenSach'],$row['TacGia'],$row['NgayNhap'],$row['GiaTien'],$row['SoLuong'],$row['SoLuongCon']));
	}
	echo json_encode($mang);
?>
