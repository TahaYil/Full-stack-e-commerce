import React from "react";
import {
  AppBar,
  Box,
  CssBaseline,
  Drawer,
  List,
  ListItem,
  ListItemButton,
  ListItemIcon,
  ListItemText,
  Toolbar,
  Typography,
  IconButton,
} from "@mui/material";
import MenuIcon from "@mui/icons-material/Menu";
import PeopleIcon from "@mui/icons-material/People";
import ShoppingCartIcon from "@mui/icons-material/ShoppingCart";
import StorefrontIcon from "@mui/icons-material/Storefront";
import { Link, useLocation } from "react-router-dom";

const drawerWidth = 240;

export default function SideBar({ children }) {
  const location = useLocation(); // Aktif sayfayı almak için

  const menuItems = [
    { text: "Products", icon: <StorefrontIcon />, path: "/products" },
    { text: "Users", icon: <PeopleIcon />, path: "/users" },
    { text: "Orders", icon: <ShoppingCartIcon />, path: "/orders" },
  ];

  return (
    <Box sx={{ display: "flex" }}>
      <CssBaseline />

      {/* Üst Menü */}
      <AppBar
        position="fixed"
        sx={{ zIndex: (theme) => theme.zIndex.drawer + 1 }}
      >
        <Toolbar>
          <IconButton color="inherit" edge="start" sx={{ mr: 2 }}>
            <MenuIcon />
          </IconButton>
          <Typography variant="h6" noWrap>
            Admin Panel
          </Typography>
        </Toolbar>
      </AppBar>

      {/* Sidebar */}
      <Drawer
        variant="permanent"
        sx={{
          width: drawerWidth,
          flexShrink: 0,
          [`& .MuiDrawer-paper`]: {
            width: drawerWidth,
            boxSizing: "border-box",
          },
        }}
      >
        <Toolbar />
        <List>
          {menuItems.map((item) => (
            <ListItem key={item.text} disablePadding>
              <ListItemButton
                component={Link}
                to={item.path}
                sx={{
                  backgroundColor:
                    location.pathname === item.path ? "#ddd" : "inherit",
                }}
              >
                <ListItemIcon>{item.icon}</ListItemIcon>
                <ListItemText primary={item.text} />
              </ListItemButton>
            </ListItem>
          ))}
        </List>
      </Drawer>

      {/* Sayfa İçeriği */}
      <Box
        component="main"
        sx={{ flexGrow: 1, p: 3, mt: "64px" }}
      >
        {children}
      </Box>
    </Box>
  );
}
