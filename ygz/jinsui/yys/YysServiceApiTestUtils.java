package ygz.jinsui.yys;

import com.thoughtworks.xstream.XStream;

import ygz.jinsui.yys.entity.ApprovedInfoResult;
import ygz.jinsui.yys.entity.EmptyInvoiceInvalidResult;
import ygz.jinsui.yys.entity.InvoiceUploadResult;
import ygz.jinsui.yys.entity.PointInfoUploadResult;
import ygz.jinsui.yys.entity.PurchasingInfoResult;
import ygz.jinsui.yys.entity.TaxpayerInfoResult;

public class YysServiceApiTestUtils {
	
	public static void print(InvoiceUploadResult result) {
		System.out.println("returnCode: " + result.getReturnCode());
		System.out.println("returnMessage: " + result.getReturnMessage());
		XStream xs = new XStream();
		System.out.println("returnCode: " + xs.toXML(result.getDetailResult()));
	}

	public static void print(EmptyInvoiceInvalidResult result) {
		System.out.println("returnCode: " + result.getReturnCode());
		System.out.println("returnMessage: " + result.getReturnMessage());
		XStream xs = new XStream();
		System.out.println("returnCode: " + xs.toXML(result.getDetailResult()));
	}

	public static void print(TaxpayerInfoResult result) {
		System.out.println("returnCode: " + result.getReturnCode());
		System.out.println("returnMessage: " + result.getReturnMessage());
		
		System.out.println("nsrsbh: " + result.get_nsrsbh());
		System.out.println("nsrmc: " + result.get_nsrmc());
		System.out.println("swjgdm: " + result.get_swjgdm());
		System.out.println("kpfsdm: " + result.get_kpfsdm());
		System.out.println("kpfsmc: " + result.get_kpfsmc());
		System.out.println("hydm: " + result.get_hydm());
		System.out.println("hymc: " + result.get_hymc());
		System.out.println("yhlx: " + result.get_yhlx());
		System.out.println("nsr_zt_dm: " + result.get_nsr_zt_dm());
		System.out.println("zg_swgy_dm: " + result.get_zg_swgy_dm());
		System.out.println("djzclx_dm: " + result.get_djzclx_dm());
		System.out.println("xzjd_dm: " + result.get_xzjd_dm());
		System.out.println("fddbrmc: " + result.get_fddbrmc());
		System.out.println("yydz: " + result.get_yydz());
		System.out.println("bsrmc: " + result.get_bsrmc());
		System.out.println("zcdz: " + result.get_zcdz());
		System.out.println("swdjblx_dm: " + result.get_swdjblx_dm());
		System.out.println("swdjzhm: " + result.get_swdjzhm());
		System.out.println("sfyxkp: " + result.get_sfyxkp());
		System.out.println("sfyxch: " + result.get_sfyxch());
		System.out.println("sfyxzf: " + result.get_sfyxzf());
	}
	
	public static void print(ApprovedInfoResult result) {
		System.out.println("returnCode: " + result.getReturnCode());
		System.out.println("returnMessage: " + result.getReturnMessage());
		System.out.println("nsrsbh: " + result.getNsrsbh());
		System.out.println("wdbh: " + result.getWdbh());
		XStream xs = new XStream();
		System.out.println("returnCode: " + xs.toXML(result.getDetailResult()));
	}
	
	public static void print(PurchasingInfoResult result) {
		System.out.println("returnCode: " + result.getReturnCode());
		System.out.println("returnMessage: " + result.getReturnMessage());
		System.out.println("nsrsbh: " + result.getNsrsbh());
		System.out.println("wdbh: " + result.getWdbh());
		XStream xs = new XStream();
		System.out.println("returnCode: " + xs.toXML(result.getDetailResult()));
	}
	
	public static void print(PointInfoUploadResult result) {
		System.out.println("returnCode: " + result.getReturnCode());
		System.out.println("returnMessage: " + result.getReturnMessage());
		System.out.println("nsrsbh: " + result.getNsrsbh());
		System.out.println("wdbh: " + result.getWdbh());
		XStream xs = new XStream();
		System.out.println("returnCode: " + xs.toXML(result.getDetailResult()));
	}
	
	
}
