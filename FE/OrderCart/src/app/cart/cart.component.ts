import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Cart } from '../Model/cart';
import { Order } from '../Model/order';
import { CartService } from '../Service/cart.service';
import { OrderService } from '../Service/order.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent {
  constructor(private router: Router ,
    private orderService: OrderService,
    private cartService: CartService) 
    {
     this.cartItems = this.cartService.getMenuItems();
     this.categories = this.cartService.getMenuCategories();
 
   }
 cartItems: Cart[] = [];
 filteredMenuItems: Cart[] = [];
 categories: string[] = [];
 searchTerm: string = '';
 

 get combinedMenuItems(): Cart[] {
   return this.filteredMenuItems.length > 0 ? this.filteredMenuItems : this.menuItems;
 }

 filterMenuItems(category: string, searchTerm: string): void {
   if (category === 'all') {
     this.filteredMenuItems = this.cartItems;
   } else {
     this.filteredMenuItems = this.cartItems.filter(item => item.category === category);
   }
 
   if (searchTerm) {
     this.filteredMenuItems = this.filteredMenuItems.filter(item =>
       item.name.toLowerCase().includes(searchTerm.toLowerCase())
     );
   }
 }

 ordernow(item: Cart): void {
   const orderItem: Order = {
     item: item,
     quantity: 1,
     amount: 1344,
     id: 101,
     productId: 233,
     orderStatus: 'Placed',
     orderDate: 
   };
   this.cartService.ordernow(orderItem);
 
   this.router.navigateByUrl('/cart'); // Redirect to the cart page
 }
 rateItem(item: Cart, rating: number): void {
   item.rating = rating;
 }
 
}
export { Cart };



