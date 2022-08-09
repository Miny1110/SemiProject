package com.svt;

import java.io.IOException;
import java.sql.Connection;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ccookat.CartDAO;
import com.ccookat.CartDTO;
import com.ccookat.CustomerDAO;
import com.ccookat.CustomerDTO;
import com.ccookat.CustomerInfo;
import com.ccookat.CustomerOrderDAO;
import com.ccookat.CustomerOrderDTO;
import com.ccookat.ItemDAO;
import com.ccookat.OrderDetailDAO;
import com.ccookat.OrderDetailDTO;
import com.util.DBConn;

public class CustomerOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	protected void forward(HttpServletRequest request, HttpServletResponse response, String url) throws ServletException, IOException {

		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Connection conn = DBConn.getconnection();
		
		CartDAO ctdao = new CartDAO(conn);
		CustomerDAO cdao = new CustomerDAO(conn);
		CustomerOrderDAO ordao = new CustomerOrderDAO(conn);
		OrderDetailDAO oddao = new OrderDetailDAO(conn);
		ItemDAO idao = new ItemDAO(conn);
		
		String cp = request.getContextPath();
		String uri = request.getRequestURI();
		String url;
		
		if(uri.indexOf("order.do")!=-1) { //장바구니에서 결제창 넘어갈때 
			String itemImagePath = cp + "/pds/itemImageFile";
			HttpSession session = request.getSession();

			CustomerInfo customerInfo = new CustomerInfo();

			customerInfo = (CustomerInfo)session.getAttribute("customerInfo");

			if(customerInfo!=null) {

				CustomerDTO cdto = new CustomerDTO();

				String customerId = customerInfo.getCustomerId();

				//회원이 장바구니에 가지고있던 모든 리스트 뽑아옴 
				List<CartDTO> lists = ctdao.selectAll(customerId); 

				int cartCount = ctdao.cartCount(customerId);

				//뿌려줄 회원정보 담아와야함 
				cdto = cdao.getReadData(customerId);				

				request.setAttribute("cartCount", cartCount);//장바구니 수량 표시해줄 데이터
				request.setAttribute("cdto", cdto);//회원정보 깔아줄 데이터
				request.setAttribute("itemImagePath", itemImagePath);//장바구니에서 이미지 끌어올 데이터
				request.setAttribute("lists", lists); //장바구니에 넣은 상품 뿌려줄 리스트

				url = "/order/orderlist.jsp";
				forward(request, response, url);	
				return;
			}
			//로그인 안되어있을때 로그인창보내기
			url = cp +"/main/customer/login.do";
			response.sendRedirect(url);
			
		}else if(uri.indexOf("order_ok.do")!=-1) { 

			//주문하기 누르면 실행되어야할것
			//1. 장바구니에서 상품 delete하기
			//2. 주문정보 테이블에 저장
			//3. 주문정보 테이블과 연결해서 주문상품 리스트 저장 

			HttpSession session = request.getSession();

			CustomerInfo customerInfo = new CustomerInfo();

			customerInfo = (CustomerInfo)session.getAttribute("customerInfo");

			if(customerInfo!=null) {
				
				String customerId = customerInfo.getCustomerId();	
				
				//주문정보 받아와야함
				//detail테이블에 정보추가
				CustomerOrderDTO ordto = new CustomerOrderDTO();
				
				ordto.setOrderNum(ordao.getMaxNum()+1);
				ordto.setCustomerId(customerId);	
				ordto.setCustomerOrderName(request.getParameter("customerOrderName"));
				ordto.setCustomerOrderZipCode(request.getParameter("customerOrderZipCode"));			
				ordto.setCustomerOrderTel(request.getParameter("customerOrderTel"));
				ordto.setCustomerOrderAddr1(request.getParameter("customerOrderAddr1"));
				ordto.setCustomerOrderAddr2(request.getParameter("customerOrderAddr2"));
				ordto.setCustomerMemo(request.getParameter("customerMemo"));
				ordto.setCustomerOrderPay(request.getParameter("customerOrderPay"));
				ordto.setCustomerOrderPrice(Integer.parseInt(request.getParameter("customerOrderPrice")));
				
				System.out.println((request.getParameter("customerOrderPrice")));
				
				ordao.insertOrderData(ordto);
				
				//detail페이지에 주문된상품 리스트 저장하고 
				//장바구니에서 삭제하는 코드
				
				OrderDetailDTO oddto = null;
				CustomerDTO cdto = new CustomerDTO();

				//장바구니에 있는 정보를 받아서
				List<CartDTO> lists = ctdao.selectAll(customerId);
				
				//반복문 돌려서 detailinsert에 데이터 추가하고 				
				Iterator<CartDTO> it = lists.iterator();
								
				while(it.hasNext()) {
						
					CartDTO cartdao = it.next();
					
					oddto = new OrderDetailDTO();
					
					oddto.setOrderNum(ordao.getMaxNum());
					oddto.setItemNum(cartdao.getItemNum());
					oddto.setItemCount(cartdao.getCartItemCount());
					oddto.setCustomerId(customerId);
					oddto.setCartTotPrice(cartdao.getCartTotPrice());
					
					oddao.insertDetailData(oddto);
					
				}
					
				//cartdelete 해야함 어차피 장바구니 전체상품 다 지워야하니까
				//id조회해서 그 id가 가지고있는거 다지우는걸로 하면될듯					
				ctdao.orderdelete(customerId);
				
				//item db연결해서 주문한 수량만큼 item재고 빼기
				//주문정보에 insert 되면 item 테이블이 수정되게끔 트리거를 실행하고 싶었으나. .. .할수없었따
				idao.afterOrder();
				
				

				//주문조회 창으로 넘어가기
				url = cp + "/main/customer/customerPwdChk.do";
				//forward(request, response, url);
				response.sendRedirect(url);
				return;
			}			
/*			//로그인 안되어있을때 로그인창보내기
			url = cp +"/main/customer/login.do";
			response.sendRedirect(url);*/
		}
	}

}