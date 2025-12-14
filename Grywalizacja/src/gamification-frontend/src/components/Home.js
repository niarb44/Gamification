import React from 'react';
import { Container, Typography, Button, Grid, Card, CardContent, CardActions } from '@mui/material';
import { styled } from '@mui/system';

const HeroContent = styled('div')({
  padding: '40px 0',
  backgroundColor: '#f5f5f5',
  textAlign: 'center',
});

const CardGrid = styled(Container)({
  paddingTop: '20px',
  paddingBottom: '20px',
});

const StyledCard = styled(Card)({
  height: '100%',
  display: 'flex',
  flexDirection: 'column',
});

function Home() {
  return (
    <div>
      <HeroContent>
        <Container maxWidth="sm">
          <Typography variant="h2" component="h1" gutterBottom>
            Welcome to Gamification Platform
          </Typography>
          <Typography variant="h5" paragraph>
            Choose your adventure: fantasy, history, animals, and more! Earn rewards, level up, and enjoy both physical and virtual prizes.
          </Typography>
          <Button variant="contained" color="primary">
            Get Started
          </Button>
        </Container>
      </HeroContent>
      <CardGrid maxWidth="md">
        <Grid container spacing={4}>
          <Grid item xs={12} sm={6} md={4}>
            <StyledCard>
              <CardContent>
                <Typography gutterBottom variant="h5" component="h2">
                  Fantasy Theme
                </Typography>
                <Typography>
                  Explore magical realms, fight dragons, and become a hero in our fantasy world!
                </Typography>
              </CardContent>
              <CardActions>
                <Button size="small" color="primary">
                  Learn More
                </Button>
              </CardActions>
            </StyledCard>
          </Grid>
          <Grid item xs={12} sm={6} md={4}>
            <StyledCard>
              <CardContent>
                <Typography gutterBottom variant="h5" component="h2">
                  Historical Theme
                </Typography>
                <Typography>
                  Relive the past and experience key historical events in our immersive history theme.
                </Typography>
              </CardContent>
              <CardActions>
                <Button size="small" color="primary">
                  Learn More
                </Button>
              </CardActions>
            </StyledCard>
          </Grid>
          <Grid item xs={12} sm={6} md={4}>
            <StyledCard>
              <CardContent>
                <Typography gutterBottom variant="h5" component="h2">
                  Animal Theme
                </Typography>
                <Typography>
                  Discover the animal kingdom, from wild beasts to friendly pets, in our animal theme.
                </Typography>
              </CardContent>
              <CardActions>
                <Button size="small" color="primary">
                  Learn More
                </Button>
              </CardActions>
            </StyledCard>
          </Grid>
        </Grid>
      </CardGrid>
    </div>
  );
}

export default Home;
