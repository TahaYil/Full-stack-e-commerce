import {
    Typography,
    Card,
    CardContent,
    CardActions,
    Box,
    CardMedia,
    IconButton,
    Container,
  } from '@mui/material';
  import { Grid } from '@mui/material';

import EditIcon from '@mui/icons-material/Edit';
import DeleteIcon from '@mui/icons-material/Delete';
  
// Örnek ürün verileri
const products = [
  {
    id: 1,
    title: 'Basic T-Shirt',
    description: 'Comfortable cotton t-shirt in various colors',
    price: 29.99,
    image: 'https://placehold.co/200x200',
  },
];
  
export default function ProductsPage() {
  const handleEdit = (productId) => {
    console.log('Edit product:', productId);
    // Edit işlemi burada yapılacak
  };

  const handleDelete = (productId) => {
    console.log('Delete product:', productId);
    // Silme işlemi burada yapılacak
  };

  console.log('Total number of products:', products.length);

  return (
    <div className='m-0 p-0'>
    <Container>
      <Typography variant="h4" gutterBottom sx={{ mb: 4 }}>
        Products
      </Typography>
      
      <Grid container spacing={1}>
        {products.map((product) => {
          console.log('Rendering product with ID:', product.id);
          return (
            <Grid item xs={12} sm={6} md={4} lg={3} key={product.id}>
              <Card 
                sx={{ 
                  height: '100%',
                  display: 'flex',
                  flexDirection: 'column',
                  transition: 'transform 0.2s',
                  '&:hover': {
                    transform: 'scale(1.02)',
                    boxShadow: 3,
                  },
                }}
              >
                <CardMedia
                  component="img"
                  height="200"
                  image={product.image}
                  alt={product.title}
                  sx={{ objectFit: 'cover' }}
                />
                <CardContent sx={{ flexGrow: 1 }}>
                  <Typography variant="h6" gutterBottom>
                    {product.title}
                  </Typography>
                  <Typography variant="body2" color="text.secondary" sx={{ mb: 2 }}>
                    {product.description}
                  </Typography>
                  <Typography variant="h6" color="primary">
                    ${product.price.toFixed(2)}
                  </Typography>
                </CardContent>
                <CardActions sx={{ justifyContent: 'flex-end', p: 2 }}>
                  <IconButton 
                    onClick={() => handleEdit(product.id)}
                    color="primary"
                    size="small"
                  >
                    <EditIcon />
                  </IconButton>
                  <IconButton 
                    onClick={() => handleDelete(product.id)}
                    color="error"
                    size="small"
                  >
                    <DeleteIcon />
                  </IconButton>
                </CardActions>
              </Card>
            </Grid>
          );
        })}
      </Grid>
    </Container>
    </div>
  );
}