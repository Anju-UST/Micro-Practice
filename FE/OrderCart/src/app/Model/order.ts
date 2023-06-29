import { Cart } from "./cart";

export interface Order {
  item:Cart;
    id: number;
    productId:number;
    quantity:number;
    orderDate: Date;
    orderStatus :string;
    amount: number;
   
  }