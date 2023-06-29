export interface Order {
    id: number;
    productId:number;
    quantity:number;
    orderDate: Date;
    orderStatus :string;
    amount: number;
   
  }