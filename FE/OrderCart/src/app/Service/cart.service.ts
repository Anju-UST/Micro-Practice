import { Injectable } from '@angular/core';
import { Cart } from '../Model/cart';
import { Order } from '../Model/order';

@Injectable({
  providedIn: 'root'
})
export class CartService {

  cartItems: Cart[] = [
    
    {
      name: 'BRIDAL',
      description: 'Description of Item 1',
      price: 10,
      image: 'assets/images/saree1.jpg',
      quantity: 1 ,
      category: 'saree',
      rating: 0
    },
    {
      name: 'kanchipuram',
      description: 'Description of Item 2',
      price: 15,
      image: 'assets/images/saree2.jpeg',
      quantity: 1 ,
      category: 'saree',
      rating: 0
},
{
  name: 'Banarasi',
  description: 'Description of Item 3',
  price: 12,
  image: 'assets/images/saree3.jpeg',
  quantity: 1 ,
  category: 'saree',
  rating: 0 
}
   
];

constructor() { }

ordernow(item: Cart): void {
  this.orderItems.push(item);
}

getMenuItems(): Cart[] {
  return this.cartItems;
}
getMenuCategories(): string[] {
  const categories = new Set<string>();
  this.cartItems.forEach(item => {
    categories.add(item.category);
  });
  return Array.from(categories);

}
ordernow(orderItem: Order) {
  throw new Error('Method not implemented.');
}
}