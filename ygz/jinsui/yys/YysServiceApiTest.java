package ygz.jinsui.yys;

import ygz.jinsui.yys.entity.ApprovedInfoResult;
import ygz.jinsui.yys.entity.Business;
import ygz.jinsui.yys.entity.Data;
import ygz.jinsui.yys.entity.DataList;
import ygz.jinsui.yys.entity.EmptyInv;
import ygz.jinsui.yys.entity.EmptyInvList;
import ygz.jinsui.yys.entity.EmptyInvoiceInvalidData;
import ygz.jinsui.yys.entity.EmptyInvoiceInvalidResult;
import ygz.jinsui.yys.entity.Group;
import ygz.jinsui.yys.entity.GroupList;
import ygz.jinsui.yys.entity.InvItem;
import ygz.jinsui.yys.entity.InvList;
import ygz.jinsui.yys.entity.InvMain;
import ygz.jinsui.yys.entity.InvoiceUploadData;
import ygz.jinsui.yys.entity.InvoiceUploadResult;
import ygz.jinsui.yys.entity.PointInfo;
import ygz.jinsui.yys.entity.PointInfoList;
import ygz.jinsui.yys.entity.PointInfoUploadData;
import ygz.jinsui.yys.entity.PointInfoUploadResult;
import ygz.jinsui.yys.entity.PurchasingInfoResult;
import ygz.jinsui.yys.entity.Request;
import ygz.jinsui.yys.entity.Response;
import ygz.jinsui.yys.entity.TaxpayerInfoResult;

public class YysServiceApiTest {
	
	/*
	 * 必要参数：
	 * 	nsrsbh：纳税人识别号
	 * 	nsrpwd：纳税人密码
	 * 	wdbh：	网点编号
	 * 	
	 * 	user：	Service 用户名
	 * 	pwd：	Service 密码
	 */
	private static String user = "";
	private static String pwd = "";
	private static String nsrsbh = "NS-BJ-OBB-SSDHC-99";
	private static String nsrpwd = "88888888";
	private static String wdbh = "wdbh-1003";
	
	public static void main(String[] args) throws Exception {
  
		YysServiceApi.debugger = new YysServiceSelfDebugger();
		YysServiceApiTest test = new YysServiceApiTest();
		
		try {
			test.fp11Test();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			test.fp12Test();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			test.fp21Test();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			test.fp40Test();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			test.fp41Test();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			test.fp90Test();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void fp11Test() throws Exception {
		YysService service = new YysService();
		TaxpayerInfoResult result = service.taxpayerInfo(nsrsbh, nsrpwd);
		YysServiceApiTestUtils.print(result);
	}
	
	public void fp12Test() throws Exception {
		YysService service = new YysService();
		ApprovedInfoResult result = service.approvedInfo(nsrsbh, nsrpwd);
		YysServiceApiTestUtils.print(result);
	}
	
	public void fp21Test() throws Exception {
		YysService service = new YysService();
		PurchasingInfoResult result = service.purchasingInfo(nsrsbh, nsrpwd, "", "");
		YysServiceApiTestUtils.print(result);
	}
	
	public void fp40Test() throws Exception {
		YysService service = new YysService();
		InvoiceUploadData data = new InvoiceUploadData();
		
		data.set_nsrsbh(nsrsbh);
		data.set_nsrpwd(nsrpwd);
		data.set_wdbh(wdbh);
		InvList lst = new InvList();
		{
			InvMain main = new InvMain();
			main.set_wdbh("wdbh"); // 网点编号
			main.set_kpf_nsrsbh("kpf_nsrsbh"); // 开票方纳税人识别号
			main.set_kpf_mc("kpf_mc"); // 开票方名称
			main.set_skf_nsrsbh("skf_nsrsbh"); // 收款方纳税人识别号
			main.set_skf_mc("skf_mc"); // 收款方名称
			main.set_fpzldm("fpzldm"); // 发票种类代码
			main.set_fpdm("fpdm"); // 发票代码
			main.set_fphm("fphm"); // 发票号码
			main.set_kprq("kprq"); // 开票日期
			main.set_kpje("kpje"); // 开票金额
			main.set_kpse("kpse"); // 开票税额
			main.set_spf_nsrsbh("spf_nsrsbh"); // 收票方纳税人识别号或证件号
			main.set_spf_mc("spf_mc"); // 收票方名称
			main.set_skm("skm"); // 税控码
			main.set_zyspmc("zyspmc"); // 主要商品名称
			main.set_zs_fpdm("zs_fpdm"); // 正数发票代码
			main.set_zs_fphm("zs_fphm"); // 正数发票号码
			main.set_fpbz("fpbz"); // 发票标志
			main.set_zfbz("zfbz"); // 作废标志
			main.set_zfrq("zfrq"); // 作废日期
			main.set_skr("skr"); // 收款人
			main.set_kpr("kpr"); // 开票人
			main.set_zfyy("zfyy"); // 作废原因
			main.set_hyfldm("hyfldm"); // 行业分类代码
			main.set_wtdkbz("wtdkbz"); // 委托代开标志
			main.set_cjbz("cjbz"); // 采集标志
			
			for ( int i = 0; i < 3; i++ ) {
				InvItem item = new InvItem();
				item.set_hh(String.valueOf(i+1)); // 行号
				item.set_hwmc("hwmc"); // 货物名称
				item.set_ggxh("ggxh"); // 规格型号
				item.set_dw("dw"); // 单位
				item.set_hwsl("hwsl"); // 数量
				item.set_dj("dj"); // 单价
				item.set_je("je"); // 金额
				item.set_sl("sl"); // 税率
				item.set_se("se"); // 税额
				
				main.addInvItem(item);
			}
			
			lst.add(main);
		}
		
		data.setInvList(lst);
		InvoiceUploadResult result = service.invoiceUpload(data);
		
		YysServiceApiTestUtils.print(result);
	}
	
	public void fp41Test() throws Exception {
		YysService service = new YysService();
		EmptyInvoiceInvalidData data = new EmptyInvoiceInvalidData();
		
		data.set_nsrsbh(nsrsbh);
		data.set_nsrpwd(nsrpwd);
		data.set_wdbh(wdbh);
		EmptyInvList lst = new EmptyInvList();
		{
			EmptyInv main = new EmptyInv();
			main.set_nsrsbh("nsrsbh"); // 纳税人识别号
			main.set_wdbh("wdbh"); // 网点编号
			main.set_fpzldm("fpzldm"); // 发票种类代码
			main.set_fpdm("fpdm"); // 发票代码
			main.set_fpqh("fpqh"); // 发票起号
			main.set_fpzh("fpzh"); // 发票止号
			main.set_zfbz("zfbz"); // 作废标志
			main.set_zfrq("zfrq"); // 作废日期
			lst.add(main);
		}
		{
			EmptyInv main = new EmptyInv();
			main.set_nsrsbh("nsrsbh"); // 纳税人识别号
			main.set_wdbh("wdbh"); // 网点编号
			main.set_fpzldm("fpzldm"); // 发票种类代码
			main.set_fpdm("fpdm"); // 发票代码
			main.set_fpqh("fpqh"); // 发票起号
			main.set_fpzh("fpzh"); // 发票止号
			main.set_zfbz("zfbz"); // 作废标志
			main.set_zfrq("zfrq"); // 作废日期
			lst.add(main);
		}
		data.setEmptyInvList(lst);
		EmptyInvoiceInvalidResult result = service.emptyInvoiceInvalid(data);
		
		YysServiceApiTestUtils.print(result);
	}
	
	public void fp90Test() throws Exception {
		YysService service = new YysService();
		PointInfoUploadData data = new PointInfoUploadData();
		
		data.set_nsrsbh(nsrsbh);
		data.set_nsrpwd(nsrpwd);
		data.set_wdbh(wdbh);
		PointInfoList lst = new PointInfoList();
		PointInfo main = new PointInfo();
		main.set_wdbh("wdbh"); // 网点编号
		main.set_wdmc("wdmc"); // 网点名称
		main.set_wdfzr("wdfzr"); // 负责人
		main.set_lxdh("lxdh"); // 联系电话
		main.set_lxdz("lxdz"); // 联系地址
		main.set_zt("zt"); // 状态
		lst.add(main);
		
		data.setPointList(lst);
		PointInfoUploadResult result = service.pointInfoUpload(data);
		
		YysServiceApiTestUtils.print(result);
	}
}
