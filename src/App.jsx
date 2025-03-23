import { Routes, Route } from "react-router-dom";
import SideBar from "./components/SideBar";
import Users from "./pages/UsersPage";
import Orders from "./pages/OrdersPage";
import ProductsPage from "./pages/PoductsPage";

function App() {
  return (
    <div>
      <SideBar>
        <Routes>
          <Route path="/" element={<ProductsPage />} />
          <Route path="/users" element={<Users />} />
          <Route path="/products" element={<ProductsPage />} />
          <Route path="/orders" element={<Orders />} />
        </Routes>
      </SideBar>
    </div>
  );
}

export default App;
